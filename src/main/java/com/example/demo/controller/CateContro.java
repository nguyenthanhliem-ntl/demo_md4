package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CateContro {
    @Autowired
    private IProductService productService;

   @ModelAttribute("categories")
    public Iterable<Product> products(){
       return productService.findAll();
   }

   @GetMapping("/product")
    public ModelAndView showListProduct(){
       Iterable<Product> producter = productService.findAll();
       ModelAndView modelAndView = new ModelAndView("/product/list");
       modelAndView.addObject("producter",producter);
       return modelAndView;
   }


   @GetMapping("/crete-product")
    public ModelAndView showAddProduct(){
       ModelAndView modelAndView = new ModelAndView("/product/create");
       modelAndView.addObject("product",new Product());
       return modelAndView;
   }

   @PostMapping("/create-product")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product){
       productService.save(product);
       ModelAndView modelAndView = new ModelAndView("/product/create");
       modelAndView.addObject("product",new Product());
       modelAndView.addObject("message","Thêm thành công!");
       return modelAndView;
   }

   @GetMapping("/edit-product/{id}")
    public ModelAndView showEditProduct(@PathVariable Long id){
       Optional<Product> productOptional = productService.findById(id);
       if(productOptional.isPresent()){
           ModelAndView modelAndView = new ModelAndView("/product/edit");
           modelAndView.addObject("product",productOptional.get());
           return modelAndView;
       }else {
           ModelAndView modelAndView = new ModelAndView("/product/error");
           return modelAndView;
       }
   }

   @PostMapping("/edit-product")
    public ModelAndView updateProduct(@ModelAttribute("product") Product product){
       productService.save(product);
       ModelAndView modelAndView = new ModelAndView("/product/edit");
       modelAndView.addObject("product",product);
       modelAndView.addObject("massage","Thay đổi thành công !");
       return modelAndView;
   }

   @GetMapping("/delete-product/{id}")
    public ModelAndView deleteProduct(@PathVariable Long id) {
       Optional<Product> product = productService.findById(id);
       if (product.isPresent()) {
           ModelAndView modelAndView = new ModelAndView("/product/delete");
           modelAndView.addObject("product", product.get());
           return modelAndView;
       } else {
           ModelAndView modelAndView = new ModelAndView("/product/error");
           return modelAndView;
       }
   }

       @PostMapping("/delete-product")
       public String deleteProduct(@ModelAttribute ("product") Product product){
           productService.remote(product.getId());
           return "redrect:product";



   }
}
