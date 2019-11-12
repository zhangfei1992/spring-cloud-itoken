package common.message;

import lombok.Data;

/**
 * 返回信息类
 * @param <T>
 */
@Data
public class Msg<T> {

    /*错误码*/
    private Integer code;

    /*提示信息 */
    private String msg;

    /*具体内容*/
    private  T data;

}
