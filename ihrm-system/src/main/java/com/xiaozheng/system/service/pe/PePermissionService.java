package com.xiaozheng.system.service.pe;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.pe.PePermissionEntity;
import com.xiaozheng.model.vo.pe.PePermissionVo;

import java.util.List;
import java.util.Map;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
public interface PePermissionService extends IService<PePermissionEntity> {

    PageUtils<PePermissionEntity> queryPage(PePermissionEntity pePermission, Map<String, Object> params);

    /**
     * 按类型保存权限
     * @param pePermissionVo
     * @return
     */
    boolean saveByType(PePermissionVo pePermissionVo) throws Exception;

    /**
     * 按类型和ID修改权限
     * @param pePermissionVo
     * @return
     */
    boolean updateByIdAndType(PePermissionVo pePermissionVo) throws Exception;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    PePermissionVo queryById(String id) throws Exception;

    boolean removeByIdAndType(List<String> asList) throws Exception;

    /**
     * 按用户 ID 或 EnVisible 查询
     * @param userId
     * @param level
     * @return
     */
    Map<String, Object> queryByUserIdOrEnVisible(String userId, String level);
}

