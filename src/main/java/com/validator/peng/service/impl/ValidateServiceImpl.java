package com.validator.peng.service.impl;

import com.validator.peng.service.ValidateService;
import org.springframework.stereotype.Component;

/**
 * impl -- ValidateService
 *
 * @since 13 十月 2018
 */
@Component
public class ValidateServiceImpl implements ValidateService {

    @Override
    public Boolean isOutRange(Integer number) {
        return 0 < number && number < 10;
    }

}
