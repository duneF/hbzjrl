package com.hbzjrl.controller;

import com.github.pagehelper.PageInfo;
import com.hbzjrl.common.NacigatePagesPlus;
import com.hbzjrl.pojo.YgPojo;
import com.hbzjrl.service.YgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/***
 *Author: Yc
 *Date:2022/4/12 9:20
 *Description:
 */
@Controller
public class YgShow {
    @Autowired
    private YgService ygService;
    private Integer pagesShuRu = 1;
    private NacigatePagesPlus nacigatePagesPlus;
    private Integer count;

    @RequestMapping("/houTaiGuanLi")
    public String houTaiGuanLi() {
        return "/houTai";
    }

    @RequestMapping("/ygShowAll")
    public String findAllByYgTable(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "8") Integer pageSize) {
        nacigatePagesPlus = new NacigatePagesPlus();
        System.out.println(pageNum + "进入findALl" + pageSize);
        if (pageSize < 1) {
            pageSize = 8;
        }

        List<YgPojo> list = ygService.findAllByYgTable(pageNum, pageSize);
        count = ygService.count();
        if (pageNum < 0 | pageNum > pagesShuRu) {
            pageNum = 1;
        }
        int[] ints = nacigatePagesPlus.pageNav(pageNum, count, 6);
        pagesShuRu = (int) Math.ceil((count / pageSize) + 0.5);
        PageInfo<YgPojo> pg = new PageInfo<>();
        pg.setPageNum(pageNum);
        pg.setPageSize(pageSize);
        pg.setTotal(count);
        pg.setPrePage(pageNum - 1);
        pg.setNextPage(pageNum + 1);
        pg.setNavigatepageNums(ints);
        pg.setPages(pagesShuRu);

        model.addAttribute("pg", pg);
        model.addAttribute("ygList", list);
        return "/yg-list";
    }

    //根据ID查找
    @RequestMapping("/ygUpdateFindById")
    public String ygUpdateFindById(Model model, YgPojo ygPojo) {
        System.out.println("进入FIndById");
        System.out.println(ygPojo.toString());
        int id = ygPojo.getUser_id();
        ygPojo = ygService.ygUpdateFindById(id);
        model.addAttribute("ygPojo", ygPojo);
        return "UpdateTan";
    }

    //根据ID修改
    @RequestMapping("/ygUpdateIng")
    public String ygUpdateIng(YgPojo ygPojo) {
        System.out.println("根据ID进入更新");
        ygService.ygUpdateIng(ygPojo);
        return "redirect:/ygShowAll";
    }

    //根据ID删除
    @RequestMapping("/deleteById")
    public String deleteById(YgPojo ygPojo) {
        int id=ygPojo.getUser_id();
        System.out.println("根据ID进入删除" + id);
        ygService.deleteById(id);
        return "redirect:/ygShowAll";
    }
    //根据渠道查找
    @RequestMapping("/ygFindByQuDao")
    public String ygFindByQuDao (Model model,YgPojo ygPojo){
        System.out.println("进入按渠道查找"+ygPojo.getWhereHome());
        List<YgPojo> list=ygService.ygFindByQuDao(ygPojo.getWhereHome());
        count = ygService.countByWhereHome(ygPojo.getWhereHome());
        model.addAttribute("count", count);
        model.addAttribute("ygList", list);

        return "/quDaoLIst";
    }
    //根据姓名查找
    @RequestMapping("/ygFindByName")
    public String ygFIndByName (Model model,YgPojo ygPojo){
        System.out.println("进入按姓名查找"+ygPojo.getName());
        List<YgPojo> list=ygService.ygFIndByName(ygPojo.getName());
        count = ygService.countByName(ygPojo.getName());
        model.addAttribute("count", count);
        model.addAttribute("ygList", list);

        return "/nameList";
    }
    //根据手机查找
    @RequestMapping("/ygFIndByPhone")
    public String ygFIndByPhone (Model model,String phoneToString){
        System.out.println("进入按手机查找"+phoneToString);
        List<YgPojo> list=ygService.ygFIndByPhone(phoneToString);
        count = ygService.conuntByPhone(phoneToString);
        model.addAttribute("count", count);
        model.addAttribute("ygList", list);
        return "/phoneList";
    }
    //根据地址查找
    @RequestMapping("/ygFIndByAddress")
    public String ygFIndByAddress (Model model,String address){
        System.out.println("进入按地址查找"+address);
        List<YgPojo> list=ygService.ygFIndByAddress(address);
        count = ygService.countByAddress(address);
        model.addAttribute("count", count);
        model.addAttribute("ygList", list);
        return "/addressList";
    }  //根据企业查找
    @RequestMapping("/ygFindByQiYe")
    public String ygFindByQiYe(Model model,String factory){
        System.out.println("进入按手机查找"+factory);
        List<YgPojo> list=ygService.ygFindByQiYe(factory);
        count = ygService.countByQiYe(factory);
        model.addAttribute("count", count);
        model.addAttribute("ygList", list);

        return "/qiYeList";
    }

    @RequestMapping("/tiaoZhuanYgAddJsp")
    public String tiaoZhuanYgAddJsp(){
        return "/ygAddYeMian";
    }
}
