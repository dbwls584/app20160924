package com.abc.my.app160924.calc;

/**
 * Created by 1027 on 2016-09-24.
 */

public interface CalcService {
    public CalcDTO plus(CalcDTO cal);
    public CalcDTO minus(CalcDTO cal);
    public CalcDTO multi(CalcDTO cal);
    public CalcDTO divide(CalcDTO cal);
    public CalcDTO remain(CalcDTO cal);
}
