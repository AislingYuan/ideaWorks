package com.cssl.controller;

import com.cssl.pojo.VoteItem;
import com.cssl.pojo.VoteOption;
import com.cssl.pojo.VoteSubject;
import com.cssl.pojo.VoteUser;
import com.cssl.service.VoteService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class VoteController {

    @Autowired
    private VoteService vs;

    //加载投票列表与按标题查询
    @RequestMapping("/load.action")
    String all(HttpSession session, Model model,Integer pageIndex, String vs_title,Integer isModify) throws IOException {
        System.err.println("===========进入加载首页============");
        VoteUser user = (VoteUser)session.getAttribute("user");
        model.addAttribute("isModify",isModify);
        if(pageIndex==null || pageIndex<=0){
            pageIndex=1;
        }
        Page<VoteSubject> vos = vs.allVo(vs_title,pageIndex);
        if(pageIndex>vos.getPages()){
            pageIndex=vos.getPages();
            vos = vs.allVo(vs_title,pageIndex);
        }
        model.addAttribute("pageIndex",pageIndex);
        for (VoteSubject voteSubject : vos) {
            int calOption = vs.calOption(voteSubject.getVs_id());
            voteSubject.setCalOption(calOption);
            int calVote = vs.calVote(voteSubject.getVs_id());
            voteSubject.setCalVote(calVote);
//            System.err.println("vos:"+vos);
            model.addAttribute("vos",vos);
        }
        return "votelist.html";
    }

    //进入投票详情
    @RequestMapping("/Vote-view.action")
    String VoteView(Model model,int vsId){
        int calOption = vs.calOption(vsId);
        int calVote = vs.calVote(vsId);
        List<VoteOption> ops = vs.allOps(vsId);
        model.addAttribute("calOption",calOption);
        model.addAttribute("calVote",calVote);
        model.addAttribute("ops",ops);
        for (VoteOption op : ops) {
            int calOps = vs.calOps(vsId, op.getVo_id());
            op.setVoteNum(calOps);
            double count=0;
            if(calVote>0){
                count = (Double.valueOf(calOps) / calVote)*100;
            }
//            System.out.println(count);
            op.setCount(count);
        }
        return "voteview.html";
    }

    //进入参与投票界面
    @RequestMapping("/voteJoin.action")
    String voteJoin(Model model,int vsId){
        model.addAttribute("vsId",vsId);
        int calOption = vs.calOption(vsId);
        int calVote = vs.calVote(vsId);
        model.addAttribute("calOption",calOption);
        model.addAttribute("calVote",calVote);
        List<VoteOption> ops = vs.allOps(vsId);
        model.addAttribute("ops",ops);
        VoteSubject vos = vs.findByVsId(vsId);
        model.addAttribute("vsType",vos.getVs_type());
        model.addAttribute("vsTitle",vos.getVs_title());
        return "vote.html";
    }

    //投票
    @RequestMapping(value = "/vote.action",method = RequestMethod.POST)
    String vote(HttpSession session,Model model, int vsId, @RequestParam(name = "options") int[] options){
        model.addAttribute("vsId",vsId);
        VoteItem vi=new VoteItem();
        vi.setVs_id(vsId);
        VoteUser user = (VoteUser) session.getAttribute("user");
        //查询投票表中是否已存在该user，如果已存在则不能投
        Integer canVote = vs.canVote(vsId, user.getUserId());
        System.err.println("canVote:"+canVote);
        if(canVote>0){
            return "forward:/voteJoin.action";
        }
        vi.setVu_user_id(user.getUserId());
//        System.out.println(Arrays.toString(options));
        for (int option : options) {
            vi.setVo_id(option);
            vs.addVote(vi);
        }
        return "forward:/Vote-view.action";
    }

    //添加投票
    @RequestMapping("/Subject-save.action")
    String addVote(HttpSession session,VoteSubject vos,String[] ops){
        System.err.println("vos:"+vos);
//        System.out.println("vOps:");
//        System.out.println("options:"+ops);
        if(vos.getVs_id()==0) {
            //当数据库中不存在该投票时
            int addVo = vs.addVo(vos);
            int vsId = vs.selectVsId(vos.getVs_title());
            if(ops!=null){
                for(int i=0;i<ops.length;i++){
                    VoteOption op=new VoteOption();
                    op.setVs_id(vsId);
                    op.setVo_option(ops[i]);
                    op.setVo_order(i+1);
                    vs.addOps(op);
                }
            }
        }else {
            //当数据中存在该投票,对投票进行修改
            //先对不存在了的已投票进行删除
            //options是原来的，ops是剩下的与新增的
            List<VoteOption> options = vs.allOps(vos.getVs_id());
            List<VoteOption> svos=new ArrayList<>();
            int num = ops.length;
            for (String option : ops) {
                //对原来的进行筛选
                VoteOption svo = vs.findByOp(option);
                if(svo!=null){
                    svos.add(svo);//将没有删除的放入集合
                }else {
                    VoteOption oo=new VoteOption();
                    oo.setVs_id(vos.getVs_id());
                    oo.setVo_option(option);
                    oo.setVo_order(num++);
                    System.err.println("add-option:"+oo);
                    vs.addOps(oo);
                }
            }
            System.err.println("svos:"+svos);
            options.removeAll(svos);
            System.err.println("options:"+options);
            for (VoteOption option : options) {
                vs.delVotes2(option.getVo_id());
                vs.delOps(option.getVo_id());
            }
            //修改标题,修改类型
            vs.updVote(vos);
        }
        return "success.html";
    }

    //进入修改界面
    @RequestMapping("/Vote-update.action")
    String upd(Model model,int vsId){
        VoteSubject voteSubject = vs.findByVsId(vsId);
        List<VoteOption> options = vs.allOps(vsId);
        voteSubject.setOptions(options);
        model.addAttribute("voteSubject",voteSubject);
        return "update.html";
    }

    //删除投票
    @RequestMapping("/Subject-remove.action")
    String del(int vsId){
        vs.delVo(vsId);
        vs.delOps(vsId);
        vs.delVotes(vsId);
        return "forward:/load.action";
    }
}
