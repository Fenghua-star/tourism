
package vip.xiaonuo.common.pojo;

import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ResponseMessage;
import vip.xiaonuo.common.enums.CommonExceptionEnum;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对Ajax请求返回Json格式数据的简易封装
 *
 * @author gtc
 *
 **/
public class CommonResult<T> implements Serializable{
    private static final long serialVersionUID = 1L;
    public static final int CODE_SUCCESS = 200;
    public static final int CODE_ERROR = 500;

    @ApiModelProperty(value = "状态码")
    private int code;

    @ApiModelProperty(value = "提示语")
    private String msg;

    @ApiModelProperty(value = "返回数据")
    private T data;

    public CommonResult() {
    }

    public CommonResult(int code, String msg, T data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }

    /**
     * 获取code
     * @return code
     */
    public Integer getCode() {
        return this.code;
    }

    /**
     * 获取msg
     * @return msg
     */
    public String getMsg() {
        return this.msg;
    }
    /**
     * 获取data
     * @return data
     */
    public T getData() {
        return this.data;
    }

    /**
     * 给code赋值，连缀风格
     * @param code code
     * @return 对象自身
     */
    public CommonResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    /**
     * 给msg赋值，连缀风格
     * @param msg msg
     * @return 对象自身
     */
    public CommonResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    /**
     * 给data赋值，连缀风格
     * @param data data
     * @return 对象自身
     */
    public CommonResult<T> setData(T data) {
        this.data = data;
        return this;
    }


    // ============================  构建  ==================================

    // 构建成功
    public static <T> CommonResult<T> ok() {
        return new CommonResult<>(CODE_SUCCESS, "操作成功", null);
    }
    public static <T> CommonResult<T> ok(String msg) {
        return new CommonResult<>(CODE_SUCCESS, msg, null);
    }
    public static <T> CommonResult<T> code(int code) {
        return new CommonResult<>(code, null, null);
    }
    public static <T> CommonResult<T> data(T data) {
        return new CommonResult<>(CODE_SUCCESS, "操作成功", data);
    }

    // 构建失败
    public static <T> CommonResult<T> error() {
        return new CommonResult<>(CODE_ERROR, "服务器异常", null);
    }
    public static <T> CommonResult<T> error(String msg) {
        return new CommonResult<>(CODE_ERROR, msg, null);
    }

    // 构建指定状态码
    public static <T> CommonResult<T> get(int code, String msg, T data) {
        return new CommonResult<>(code, msg, data);
    }

    /*
     * toString()
     */
    @Override
    public String toString() {
        return "{"
                + "\"code\": " + this.getCode()
                + ", \"msg\": \"" + this.getMsg() + "\""
                + ", \"data\": \"" + this.getData() + "\""
                + "}";
    }

    /**
     * 响应状态码集合
     *
     * @author gtc
     *
     **/
    public static List<ResponseMessage> responseList() {
        return Arrays.stream(CommonExceptionEnum.values()).map(commonExceptionEnum -> new ResponseMessageBuilder()
                .code(commonExceptionEnum.getCode()).message(commonExceptionEnum.getMessage()).build())
                .collect(Collectors.toList());
    }
}
