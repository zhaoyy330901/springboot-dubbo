package dubbo.server.service;

import com.alibaba.dubbo.config.annotation.Service;
import dubbo.api.CostService;

@Service
public class CostServiceImpl implements CostService {
    private final Integer totalCost = 1000;

    @Override
    public Integer add(int cost) {
        System.out.println("调用costservice的实现类...");
        return cost+totalCost;
    }
}
