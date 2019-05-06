package dubbo.client.service;

import com.alibaba.dubbo.config.annotation.Reference;
import dubbo.api.CostService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Reference //消费dubbo服务
    private CostService costService;
    @Override
    public Integer getCost(int a) {
        System.out.println("执行了client--->ProductServiceImpl");
        return costService.add(a);
    }
}
