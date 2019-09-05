package com.xgit.iot.infra;

/**
 * Created by huaxiulin on 2017/4/11.
 */
public enum ErrorCode {
    Success(0, "操作成功"),
    Failure(1, "操作失败"),
    NeedLogin(2, "用户没有登录或超时,请重新登录"),
    UnExceptedError(3, "未知的错误发生"),
    IllegalArument(4, "参数错误"),
    SQLIntegrityConstraintViolation(5, "违反完整性约束"),
    NoAuthorization(6, "没有权限执行此操作"),
    CheckLoginFailure(7, "用户不存在或者密码错误"),
    UserNameExists(8, "登录名称已存在"),
    RoleNameExists(9, "角色名已存在"),
    RoleIsUsed(10, "角色已经被使用"),
    UserLocked(11, "用户被锁定"),
    OldPwdNotRight(12, "原密码不正确"),
    NewPwdNotMatchConfirmPwd(13, "新密码与确认密码不一致"),
    SqlSyntaxError(14, "数据库执行异常"),
    /**
     * ----------------------------------------------------------------
     * 线以上内容请不要修改
     * ----------------------------------------------------------------
     **/
    YourErrorCodeGoesHere(1000, "你的失败码请在后面定义"),

    /**
     * 业务系统公共错误码1000
     */
    CommGetGenIdFailed(1000 + 1, "生成id失败"),
    CommObjectNotTargetClass(1000 + 2, "对象非目标类型"),
    ParameterInError(1000 + 3, "入参错误"),

    /**
     * 文件类相关1100
     */
    CommFileCreateFailed(1100 + 1, "文件创建失败"),
    CommFileUploadUnSupportByThrid(1100 + 2, "暂不支持使用第三方上传文件"),
    CommFileUploadCantNull(1100 + 3, "上传的文件不能为空"),
    CommFileGetBytesFailed(1100 + 4, "获取文件字节数组失败"),
    FileTypeUnValid(1100 + 5, "文件格式不正确"),
    FileWriteFalid(1100 + 6, "文件写入失败"),
    FileWrite2WoorkbookFalid(1100 + 7, "从文件写入工作溥失败"),
    CommFileUploadTooBig(1100 + 8, "上传的文件过大"),

    //EXCEL模块：1200
    ImportExcelFalid(1200 + 1, "导入Excel失败"),
    ImportExcelExistsNullRow(1200 + 2, "导入的Excel中存在空行"),
    ImportExcelLackFiled(1200 + 3, "导入的Excel中缺少必要的字段，或字段名称有误"),
    ImportExcelOutPutColumnUndefined(1200 + 4, "输出对象中的字段类型未找到"),
    ImportExcelHasRepeatData(1200 + 5, "导入的excel中指定行中有重复数据，请查看返回的excel"),
    ImportExcelHasUnValidData(1200 + 6, "导入的excel中存在无效数据，请查看返回的excel"),
    ImportExcelUniqueColumnUnValid(1200 + 7, "导入的excel中指定行无效"),
    ImportExcelIsNull(1200 + 8, "导入的excel中无数据"),
    ImportExcelHasFormatUnValidData(1200 + 9, "导入的excel中存在格式不正确的数据，请查看返回的excel"),
    ImportExcelVersionNotMatch(1200 + 10, "暂不支持Excel2007版本,请另存为Excel2003版本！"),
    ImportExcelFormatError(1200 + 11, "excel 格式错误！"),
    ImportExcelEndWithXLS(1200 + 12, "请导入以.xls结尾的excel文件"),
    ImportExcelDataTransTextException(1200 + 13, "导入的数据转换为文本格式出现异常"),
    ImportExcelDataTransInstantiationExcetion(1200 + 14, "实体类没有构造函数"),
    CreateMocDpuSendTableFail(1200 + 15, "指令下发当月表创建失败"),

    /**
     * 请求外部服务 1300
     */
    RestTempleateNotParamInURL(1300 + 1, "请求外部服务未传入url"),
    RestTempleateConnecTimeout(1300 + 2, "请求外部服务超时"),
    RestTempleateConnectFailed(1300 + 3, "请求外部服务失败"),

    /**
     * 数据字典 2100
     */
    DataDictionaryIsExists(2100 + 1, "数据字典已存在"),
    DataDictionaryCantRemove(2100 + 2, "所选分类下存在子分类，不允许删除"),


    /**
     * 机构管理 2200
     */
    CompanyNoGenerateError(2200 + 1, "公司编号生成出错"),
    CpyNameHasExist(2200 + 2, "公司名称已存在"),
    AddWorkSpaceExpection(2200 + 3, "新增工作空间异常"),
    AddWorkSpaceFail(2200 + 4, "新增工作空间失败"),
    EnableCompanyFail(2200 + 5, "停用启用企业失败"),
    DeleteCompanyFail(2200 + 6, "删除企业失败"),

    /**
     * 用户管理 2300
     */
    IusProfileInsertFailure(2300 + 1, "新增用户信息失败"),
    IusProfileUpdateFailure(2300 + 2, "更新用户信息失败"),
    DeleteIusProfileFailure(2300 + 3, "删除用户信息失败"),
    IusUserRolesInsertFailure(2300 + 4, "新增用户角色关系失败"),
    IusUserRolesUpdateFailure(2300 + 5, "更新用户角色关系失败"),
    DeleteIusUserRolesFailure(2300 + 6, "删除用户角色关系失败"),
    IusAccountInsertFailure(2300 + 7, "新增账号信息表失败"),
    IusAccountUpdateFailure(2300 + 8, "更新账号信息表失败"),
    DeleteIusAccountFailure(2300 + 9, "删除账号信息表失败"),
    IusPasswordInsertFailure(2300 + 10, "新增密码信息失败"),
    IusPasswordUpdateFailure(2300 + 11, "更新密码信息失败"),
    DeleteIusPasswordFailure(2300 + 12, "删除密码信息失败"),
    NoPhoneFailure(2300 + 13, "没有手机号码新增用户失败"),


    //系统日志 2400


    //位置分布 2450


    //车辆列表 2500


    //多屏监控 2600
    ScreenHasExist(2600 + 1, "车辆监控已存在"),
    ScreenNotExist(2600 + 2, "车辆监控不存在"),

    //报警列表 2700


    //车队点检 2800
    RepairStatusAlarm(2800 + 1, "维修状态已变更，无法撤销"),

    //排班管理 2900
    GroupArrangeHasExist(2900 + 1, "排班信息已存在"),
    GroupArrangeNotExist(2900 + 2, "排班信息不存在"),
    GroupArrangeDetailHasExist(2900 + 3, "同时段内车辆不能重复排班"),
    GroupArrangeWorkHasExist(2900 + 4, "同班次内车辆不能重复排班"),
    GroupArrangeStartTimeOverEndTime(2900 + 5, "开始时间大于等于结束时间"),
    //倒运任务 3000


    //加油记录 3100


    //加油卡管理 3200
    OilCardHasExist(3200 + 1, "加油卡卡号已存在"),
    OilCardInsertFailure(3200 + 2, "新增加油卡信息失败"),
    OilCardUpdateFailure(3200 + 3, "更新加油卡信息失败"),
    DeleteOilCardFailure(3200 + 4, "删除加油卡信息失败"),


    //保养提醒 3300


    //保养记录 3400
    VehicleMaintenanceRecordInsertFailure(3400 + 1, "新增车辆保养记录表信息失败"),
    VehicleMaintenanceRecordUpdateFailure(3400 + 2, "更新车辆保养记录表信息失败"),
    DeleteVehicleMaintenanceRecordFailure(3400 + 3, "删除车辆保养记录表信息失败"),
    VehicleMaintenanceRecordDetailInsertFailure(3400 + 4, "新增车辆保养记录明细信息失败"),
    VehicleMaintenanceRecordDetailUpdateFailure(3400 + 5, "更新车辆保养记录明细信息失败"),
    DeleteVehicleMaintenanceRecordDetailFailure(3400 + 6, "删除车辆保养记录明细信息失败"),


    //保养反馈 3500


    //维修记录 3600
    REPAIR_ROCROD_FINISHED(3600 + 1, "该维修单已完成，不能指派"),

    //工时定额表 3700


    //维修资料库 3800


    //故障类型 3900
    TROUBLETYPEHASNAME(3900 + 1, "故障名称已存在"),

    //备件查询 4000

    //行车路线 4100

    //电子围栏 4200


    //报警策略 4300
    VehicleAlarmConfigInsertFailure(4300 + 1, "新增车辆报警设置信息失败"),

    VehicleAlarmConfigUpdateFailure(4300 + 2, "更新车辆报警设置信息失败"),

    DeleteVehicleAlarmConfigFailure(4300 + 3, "删除车辆报警设置信息失败"),

    VehicleAlarmConfigDetailInsertFailure(4300 + 4, "新增车辆报警设置明细表信息失败"),

    VehicleAlarmConfigDetailUpdateFailure(4300 + 5, "更新车辆报警设置明细表信息失败"),

    DeleteVehicleAlarmConfigDetailFailure(4300 + 6, "删除车辆报警设置明细表信息失败"),


    //车辆型号 4400
    VehicleModelNameHasExist(4400 + 1, "车辆型号名称已存在"),

    VehicleModelNameNotExist(4400 + 2, "车辆型号名称不存在"),

    VehicleModelInsertFailure(4400 + 3, "新增车辆型号信息失败"),

    VehicleModelInsertSuccess(4400 + 4, "新增车辆型号信息成功"),

    VehicleModelUpdateFailure(4400 + 5, "更新车辆型号信息失败"),

    VehicleModelUpdateSuccess(4400 + 6, "更新车辆型号信息成功"),

    DeleteVehicleModelFailure(4400 + 7, "删除车辆型号信息失败"),

    DeleteVehicleModelSuccess(4400 + 8, "删除车辆型号信息成功"),


    //车辆管理 4500
    VehicleInfoHasExist(4500 + 1, "车牌号已存在"),

    VehicleInfoNotExist(4500 + 2, "车牌号不存在"),

    VehicleInfoInsertStatusFailure(4500 + 3, "新增状态信息失败"),

    VehicleInfoInsertStatusSuccess(4500 + 4, "新增状态信息成功"),

    VehicleInfoInsertRelevanceFailure(4500 + 5, "新增终端绑定记录信息失败"),

    VehicleInfoInsertRelevanceSuccess(4500 + 6, "新增终端绑定记录信息成功"),

    DeleteVehicleInfoFailure(4500 + 7, "删除车辆失败"),

    DeleteVehicleInfoSuccess(4500 + 8, "删除车辆成功"),

    //终端管理 4600
    DeviceCodeHasExist(4600 + 1, "终端编号已存在"),

    DeviceCodeNotExist(4600 + 2, "终端编号不存在"),

    DeviceInfoInsertFailure(4600 + 3, "新增终端信息失败"),

    DeviceInfoInsertSuccess(4600 + 4, "新增终端信息成功"),

    DeviceInfoUpdateFailure(4600 + 5, "更新终端信息失败"),

    DeviceInfoUpdateSuccess(4600 + 6, "更新终端信息成功"),

    DeleteDeviceInfoFailure(4600 + 7, "删除终端信息失败"),

    DeleteDeviceInfoSuccess(4600 + 8, "删除终端信息成功"),

    //班组管理 4700
    GroupHasExist(4700 + 1, "班组信息已存在"),

    GroupNotExist(4700 + 2, "班组信息不存在"),

    GroupHasUsed(4700 + 3, "班组已被使用,不允许删除"),

    //人员管理 4800
    PersonnelHasExist(4800 + 1, "员工信息已存在"),

    PersonnelNotExist(4800 + 2, "员工信息不存在"),

    PersonnelMobileHasExist(4800 + 3, "手机号已存在"),

    PersonnelMobileNotExist(4800 + 4, "手机号不存在"),

    //车辆类型 4900


    //车辆运行情况统计 5000

    //撤回操作
    WITHDRAWNOLOG(5200 + 1, "未找到操作日志"),

    WITHDRAWHASCANCEL(5200 + 2, "不允许连续撤销"),

    //保养策略 5100
    MaintenanceStrategyInsertFailure(5100 + 1, "新增保养策略信息失败"),

    MaintenanceStrategyUpdateFailure(5100 + 2, "更新保养策略信息失败"),

    MaintenanceStrategyRemoveFailure(5100 + 3, "删除保养策略信息失败");


    private String desc;
    private int code;

    ErrorCode(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }
}
