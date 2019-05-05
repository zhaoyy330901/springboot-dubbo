package dubbo.client.controller;

import dubbo.client.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/add")
    public String getCost(int a){
       return "该产品总共消费 ："+productService.getCost(a);
    }
}
