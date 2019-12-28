package com.kaysanshi.springbootshop.controller;

import com.kaysanshi.springbootshop.domain.*;
import com.kaysanshi.springbootshop.dto.BaseResult;
import com.kaysanshi.springbootshop.dto.CategoryDTO;
import com.kaysanshi.springbootshop.dto.ProductQueryVO;
import com.kaysanshi.springbootshop.service.BannerService;
import com.kaysanshi.springbootshop.service.CategoryService;
import com.kaysanshi.springbootshop.service.ProductService;
import com.kaysanshi.springbootshop.utils.Myutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @Author kay三石
 * @date:2019/11/25
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;



    /**
     * 添加商品
     * @param product
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public BaseResult addProduct(Product product,HttpServletRequest request){
        String uid=UUID.randomUUID().toString();
        product.setId(UUID.nameUUIDFromBytes((uid).getBytes()).toString());
        //product.setId(String.valueOf(Myutils.genItemId()));
        product.setCreateTime(new Date());
        Admin admin=(Admin) request.getSession().getAttribute("user");
        if (admin==null){
            return  BaseResult.createErrorMessageResult(null,"用户未登录或登录失效");
        }
        product.setCreateUser(String.valueOf(admin.getId()));
        Product prod=productService.add(product);
        if(prod!=null){
            return BaseResult.success(prod);
        }else{
            return BaseResult.error("添加失败");
        }

    }

    /**
     * 修改商品
     * @param product
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult updateProduct(Product product){
        product.setUpdateTime(new Date());
        Product product1=productService.update(product);
        if(product1!=null){
            return BaseResult.success(product1);
        }else{
            return BaseResult.error("修改失败");
        }
    }

    /**
     * 删除商品
     * @param product
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult deleteProduct(Product product){
        product.setId(product.getId());
        if (productService.delete(product)!=null){
            return BaseResult.success(null);
        }else{
            return BaseResult.error(null);
        }
    }
    /**
     * 后台显示出商品列表
     *
     */
    @RequestMapping("/list")
    @ResponseBody
    public BaseResult getProductList(ProductQueryVO productQueryVO){
        return productService.getlist(productQueryVO);
    }
    /**
     *  分页查询商品
     * @param response
     * @param request
     * @return
     */
    @RequestMapping("/page/list")
    @ResponseBody
    public BaseResult getProductList(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                     @RequestParam(name = "limit", defaultValue = "10") Integer size,
                                     @RequestParam(name = "search", required = false) String search,
                                     @RequestParam(name = "public_status", required = false) String publicStatus,
                                     @RequestParam(name = "new_status", required = false) String newStatus,
                                     @RequestParam(name = "sort",required = false) String sort,
                                     HttpServletResponse response,HttpServletRequest request){
        return BaseResult.success(productService.getList(page,size,search,publicStatus,newStatus,sort,request,response));

    }

    /**
     * 通过id获取商品
     * @param product
     * @return
     */
    @RequestMapping("/get")
    @ResponseBody
    public BaseResult getProductById(Product product){

        if (product.getId()!=null){
            return BaseResult.success(productService.getProduct(product));
        }else{
            return BaseResult.error(null);
        }
    }
    @RequestMapping("/list/dto")
    @ResponseBody
    public List<Category> getList(String cid){
        List<Category> list=categoryService.getCategoryDTOListBycid(cid);
        return list;
    }


    /**
     * 获取商品总数
     * @return
     */
    @RequestMapping("/count")
    @ResponseBody
    public BaseResult getCount(){
        return BaseResult.success(productService.getCount(new Product()));
    }


    /**
     * 分类添加
     * @param category
     * @return
     */
    @RequestMapping("/category/add")
    @ResponseBody
    public BaseResult addCategory(Category category){
        //获取到pid不为null时有父级菜单
        if (category.getPid()!=null){
            return  BaseResult.success(categoryService.addCategory(category));
        }else{
            return BaseResult.error(null);
        }

    }

    /**
     * 分类修改
     * @param category
     * @return
     */
    @RequestMapping(value = "/category/update",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult updateCategory(Category category){
        if (category.getId()!=null){
            return BaseResult.success(categoryService.updateCategory(category));
        }else{
            return BaseResult.error(null);
        }
    }

    /**
     * 分类删除
     * @param category
     * @return
     */
    @RequestMapping(value = "/category/delete",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult deleteCategory(Category category){
        if (category.getId()!=null){
            categoryService.deleteCategory(category);
            return BaseResult.success(null);
        }else{
            return BaseResult.error(null);
        }
    }

    /**
     * 获取分类的列表，包含父子级关系
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/category/list", method=RequestMethod.GET)
    @ResponseBody
    public BaseResult getListCategory(HttpServletRequest request, HttpServletResponse response){
        List<Category> list=categoryService.getCategoryList();
        if(list!=null){
            return BaseResult.success(list);
        }else{
            return BaseResult.error(null);
        }
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/categorydto/list", method=RequestMethod.GET)
    @ResponseBody
    public List<CategoryDTO> getListCateGoryDto(){
        List<CategoryDTO> list=categoryService.getCategoryDTOList();
        if (list!=null){
            return list;
        }else{
            return list;
        }
    }

    /**
     * 获取列表，不包含父级关系
     * @param response
     * @param request
     * @return
     */
    @RequestMapping(value = "/category/listall",method = RequestMethod.GET)
    @ResponseBody
    public BaseResult getListCategoryById(HttpServletResponse response,HttpServletRequest request){
        List<Category> list=categoryService.getCategoryListAll();
        if (list!=null){
            return BaseResult.success(list);
        }else{
            return BaseResult.error(null);
        }
    }
    @RequestMapping(value = "/category/test_list",method = RequestMethod.GET)
    @ResponseBody
    public List<Category> getListCategoryByList(HttpServletResponse response, HttpServletRequest request){
        List<Category> list=categoryService.getCategoryListAll();
        if (list!=null){
            return list;
        }else{
            return list;
        }
    }


    /**
     * 通过id 获取到这个分类
     * @param category
     * @return
     */
    @RequestMapping(value = "/category/get",method = RequestMethod.GET)
    @ResponseBody
    public BaseResult getListCategoryById(Category category){
       if (category.getId()!=null){
           Category category1=categoryService.getCategoryListById(category);
           return BaseResult.success(category1);
       }else{
           return BaseResult.error("id为null");
       }

    }


}
