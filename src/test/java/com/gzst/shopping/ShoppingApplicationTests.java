package com.gzst.shopping;

import com.gzst.shopping.dao.AddressMapper;
import com.gzst.shopping.model.Address;
import com.gzst.shopping.model.AddressExample;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ShoppingApplicationTests {

    @Resource
    private AddressMapper addressMapper;

    @Test
    void contextLoads() {
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andIdBetween(59L, 61L);
        criteria.andAddressLike("%大%");
        List<Address> addresses = addressMapper.selectByExample(addressExample);
        for (Address address : addresses) {
            System.out.println(address);
        }
    }

}
