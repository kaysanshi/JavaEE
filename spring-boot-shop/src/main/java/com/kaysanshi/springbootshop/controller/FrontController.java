package com.kaysanshi.springbootshop.controller;

import com.kaysanshi.springbootshop.domain.Banner;
import com.kaysanshi.springbootshop.domain.Category;
import com.kaysanshi.springbootshop.domain.Product;
import com.kaysanshi.springbootshop.domain.User;
import com.kaysanshi.springbootshop.dto.Cart;
import com.kaysanshi.springbootshop.dto.CategoryDTO;
import com.kaysanshi.springbootshop.service.BannerService;
import com.kaysanshi.springbootshop.service.CategoryService;
import com.kaysanshi.springbootshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author kay三石
 * @date:2019/12/15
 */
@Controller
@RequestMapping("/front")
public class FrontController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BannerService bannerService;

    @Autowired
    private ProductService productService;

    /**
     * index页面
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String index(Model model,HttpServletRequest request){
        List<CategoryDTO> list=categoryService.getCategoryDTOList();
        if(list!=null) {
            model.addAttribute("categoryList", list);
        }
        List<Banner> list1=bannerService.getlistByPosition();
        model.addAttribute("bannerList",list1);
        List<Product> hotproductlist=productService.gethotProductlist();
        System.out.println(hotproductlist);
        model.addAttribute("hotProductlist",hotproductlist);
        List<Product> recomendProductList=productService.getRecomendProductList();
        model.addAttribute("recomendProductList",recomendProductList);
        List<Product> mobileProductList=productService.getMobileProcuctByCategory(); // 手机
        model.addAttribute("mobileProductList",mobileProductList);
        List<Product> closeProductList=productService.getcloseProcuctByCategory(); // 服饰
        List<Product> heaProductList=productService.getHEAProductByCategory(); // 家用电器
        model.addAttribute("clotheProductList",closeProductList);
        model.addAttribute("heaProductList",heaProductList);
        if (request.getSession().getAttribute("loginUser")!=null){
            HttpSession session = request.getSession();
            User user= (User) request.getSession().getAttribute("loginUser");
            session.setAttribute("loginUser",user);
        }
        return "index";
    }
    @GetMapping("/detail")
    public String detail(Model model, HttpServletRequest request){
        Product product=new Product();
        product.setId(request.getParameter("id"));
        if (product.getId()!=null){
           Product product1=productService.getProduct(product);
            String cid = product1.getCid();
            List<Category> list=categoryService.getCategoryDTOListBycid(cid);
            if(list!=null) {
                model.addAttribute("categoryList", list);
            }
            model.addAttribute("productDetail",product1);
        }
        List<Product> recomendProductList=productService.getRecomendProductList();
        model.addAttribute("recomendProductList",recomendProductList);
        return "item";
    }
    @GetMapping("/cart")
    public String cart(Model model, HttpServletRequest request, HttpServletResponse response){
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        System.out.println(cart);
        model.addAttribute("cartItem",cart);
        return "cart";
    }
    @GetMapping("/order")
    public String order(Model model, HttpServletRequest request, HttpServletResponse response){
        // 返回到order页面
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (request.getSession().getAttribute("loginUser")!=null){
            HttpSession session = request.getSession();
            User user= (User) request.getSession().getAttribute("loginUser");
            session.setAttribute("loginUser",user);
        }
        model.addAttribute("orderlist",cart);
        return "order";
    }
    @GetMapping("/login")
    public String login(Model model,HttpServletRequest request, HttpServletResponse response){

        return "login";
    }

}
