package com.bdtravel.controller;

import com.bdtravel.entity.QueryVo;
import com.bdtravel.entity.Scenic;
import com.bdtravel.entity.TastyFood;
import com.bdtravel.service.FoodService;
import com.bdtravel.utils.Page;
import com.bdtravel.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FoodController {
    @Autowired
    FoodService foodService;

    /**
     * 管理员管理美食资讯
     * @param model
     * @param vo
     * @return
     */
    @RequestMapping(value = "/manageFood")
    public String getFoodPage(Model model,QueryVo vo){
        Page<TastyFood> page = foodService.selectFoodPageByQueryVo(vo);
        model.addAttribute("page", page);
        model.addAttribute("name",vo.getName());
        return "manager/food";
    }


    /**
     * 为用户展示所有美食getScenicPageForUser
     * @param model
     * @return
     */
    @RequestMapping(value = "/getFoodPageForUser")
    public String listFoodPageToUser(Model model,QueryVo vo){
        Page<TastyFood> page = foodService.selectFoodPageByQueryVo(vo);
        model.addAttribute("page", page);
        return "user/foodList";
    }

    /**
     * 管理员新增美食信息
     * @param tastyFood
     * @return
     */
    @RequestMapping(value = "/addFood")
    public String insert(TastyFood tastyFood, MultipartFile foodImage){
        //当上传的图片不为空的时候才去存储路径,否则不存
        if (foodImage.getSize() != 0) {
            //将上传的文件保存到磁盘中
            String path = "E:\\project\\bdtravel\\src\\main\\webapp\\image\\foodpic";
            String imageName = UploadUtil.upload(foodImage,path);
            System.out.println(imageName);
            //将图片路径封装到Scenic中
            tastyFood.setPic("/image/foodpic/"+imageName);
            System.out.println(tastyFood.getPic());
        }
        //插入
        foodService.addFood(tastyFood);
        return "redirect:/manageFood";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteFood")
    String deleteScenic(Integer id){
        //删除
        foodService.deleteById(id);
        return "redirect:/manageFood";
    }

    /**
     * 管理员修改美食信息
     * @param
     * @return
     */
    @RequestMapping(value = "/updateFood")
    public String update(TastyFood tastyFood,MultipartFile foodImage){
        //当上传的图片不为空的时候才去存储路径,否则不存
        if (foodImage.getSize() != 0) {
            //将上传的文件保存到磁盘中
            String path = "E:\\project\\bdtravel\\src\\main\\webapp\\image\\foodpic";
            String imageName = UploadUtil.upload(foodImage,path);
            //将图片路径封装到Scenic中
            tastyFood.setPic("/image/foodpic/"+imageName);
        }
        foodService.updateFood(tastyFood);
        return "redirect:/manageFood";
    }

    /**
     * 根据id获得美食信息
     * @param
     * @return
     */
    @RequestMapping(value = "/getFoodById")
    public @ResponseBody
    TastyFood getFoodById(Integer id){
        TastyFood tastyFood = foodService.getFoodById(id);
        return tastyFood;
    }
}