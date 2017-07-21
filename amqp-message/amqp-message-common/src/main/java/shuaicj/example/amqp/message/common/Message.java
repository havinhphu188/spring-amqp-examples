package shuaicj.example.amqp.message.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * A simple message.
 *
 * @author shuaicj 2017/07/21
 */
@Getter
@AllArgsConstructor
@ToString
@SuppressWarnings("serial")
public class Message implements Serializable {

    private String id;
    private String content;
}
