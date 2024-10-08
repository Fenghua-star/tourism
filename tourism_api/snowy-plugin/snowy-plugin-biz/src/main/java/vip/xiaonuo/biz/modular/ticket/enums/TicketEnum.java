
package vip.xiaonuo.biz.modular.ticket.enums;

import lombok.Getter;

/**
 * 景点门票表枚举
 *
 * @author gtc
 *
 **/
@Getter
public enum TicketEnum {

    /** 测试 */
    TEST("TEST");

    private final String value;

    TicketEnum(String value) {
        this.value = value;
    }
}
