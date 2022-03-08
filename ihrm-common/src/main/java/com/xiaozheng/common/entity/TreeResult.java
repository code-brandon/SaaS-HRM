package com.xiaozheng.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 树结果
 *
 * @author Xiao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("树结果")
public class TreeResult<T> implements Serializable {
    /**
     * @Fields id : 编号
     */
    @ApiModelProperty("编号")
    private Long id;
    /**
     * @Fields text : 文字
     */
    @ApiModelProperty("文字")
    private String text;
    /**
     * @Fields pid :父目录的id
     */
    @ApiModelProperty("父目录的id")
    private Long pid;
    /**
     * @Fields levels : 所在级别
     */
    @ApiModelProperty("所在级别")
    private Long levels;
    /**
     * @Fields children : 子节点集合
     */
    @ApiModelProperty("子节点集合")
    private List<T> children = new ArrayList();

    // Constructors


    /** minimal constructor */
    public TreeResult(Long id, String text) {
        this.id = id;
        this.text = text;
    }


    /** full constructor */
    public TreeResult(Long id, String text, Long pid) {
        this.id = id;
        this.text = text;
        this.pid = pid;
    }


    public TreeResult(Long id, String text, Long pid, List children) {
        super();
        this.id = id;
        this.text = text;
        this.pid = pid;
        this.children = children;
    }

}
