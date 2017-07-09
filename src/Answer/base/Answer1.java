package Answer.base;

import Answer.base.convert.ArgsConvert;

/**
 * 一个String参数的答案类型
 */
public abstract class Answer1 extends BaseArgsAnswer {

    public Answer1() {
        super(1);
    }

    public String getArgs1(){
        return mArgs[0] + "";
    }

    @Override
    protected ArgsConvert[] getConverts() {
        return new ArgsConvert[]{null};
    }
}