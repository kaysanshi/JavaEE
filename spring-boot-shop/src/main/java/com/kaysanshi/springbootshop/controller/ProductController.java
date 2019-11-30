package com.kaysanshi.springbootshop.controller;

import com.kaysanshi.springbootshop.domain.Category;
import com.kaysanshi.springbootshop.domain.Product;
import com.kaysanshi.springbootshop.dto.BaseResult;
import com.kaysanshi.springbootshop.dto.ProductQueryVO;
import com.kaysanshi.springbootshop.service.CategoryService;
import com.kaysanshi.springbootshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

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
    public BaseResult addProduct(Product product){
        product.setId(UUID.randomUUID().toString());
        if(productService.add(product)!=null){
            return BaseResult.success(productService.add(product));
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
        if(productService.update(product)!=null){
            return BaseResult.success(productService.update(product));
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
        if(categoryService.getCategoryList()!=null){
            return BaseResult.success(categoryService.getCategoryList());
        }else{
            return BaseResult.error(null);
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
