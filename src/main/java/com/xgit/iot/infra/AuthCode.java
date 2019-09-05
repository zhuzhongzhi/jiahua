package com.xgit.iot.infra;

/**
 * 授权码
 */
public interface AuthCode {

    //系统管理-数据字典
    long dataDictionary = 1100;

    //系统管理-用户管理
    long iusProfile = 2200;

    //系统管理-公司管理
    long company = 2300;

    //系统管理-角色管理
    long iusRole = 2400;

    //车辆监控-位置分布
    long placeDisposition = 3100;

    //调度管理-排班管理
    long workGroupArrange = 3200;

    //车辆监控-多屏监控
    long screenMonitor = 3300;

    //调度管理-车队点检
    long teamTally = 3400;

    //资源管理-班组管理
    long workGroup = 4400;

    //资源管理-车辆管理
    long vehicleInfo = 4500;

    //资源管理-人员管理
    long workPersonnel = 4600;

    //资源管理-车辆型号
    long vehicleModel = 4700;

    //资源管理-终端管理
    long deviceInfo = 4800;

    //资源管理-车辆类型
    long vehicleType = 4900;

    //保养管理-保养提醒
    long maintenanceRemaind = 5000;

    //保养管理-保养记录
    long maintenanceRecord = 5100;

    //保养管理-保养策略
    long maintenanceStrategy = 5200;

    //保养管理-保养反馈
    long maintenanceReturn = 5300;

    //报警设置-行车路线
    long vehicleLine = 6100;

    //报警设置-电子围栏
    long vehicleFence = 6200;

    //报警设置-停车点
    long vehicleStop = 6300;


    //加油管理-加油卡管理
    long oilCard = 7100;

    //加油管理-加油记录
    long oilAddRecord =7200;

    //维修管理-备件查询
    long repairPart = 8100;


    /**
     * 系统管理
     */
    interface SystemManage {
        /**
         * 数据字典
         */
        interface DataDictionary {
            /**
             * 新增参数
             */
            long ADD = dataDictionary + 1;
            /**
             * 编辑参数
             */
            long EDIT = dataDictionary + 2;
            /**
             * 删除参数
             */
            long REMOVE = dataDictionary + 3;
            /**
             * 查看
             */
            long QUERY = dataDictionary + 4;
        }

        /**
         * 用户管理
         */
        interface IusProfile {
            /**
             * 新增参数
             */
            long ADD = iusProfile + 1;
            /**
             * 编辑参数
             */
            long EDIT = iusProfile + 2;
            /**
             * 删除参数
             */
            long REMOVE = iusProfile + 3;
            /**
             * 查看
             */
            long QUERY = iusProfile + 4;
        }


        /**
         * 公司管理
         */
        interface Company {
            /**
             * 新增参数
             */
            long ADD = company + 1;
            /**
             * 编辑参数
             */
            long EDIT = company + 2;
            /**
             * 删除参数
             */
            long REMOVE = company + 3;
            /**
             * 查看
             */
            long QUERY = company + 4;
        }

        /**
         * 角色管理
         */
        interface IusRole {
            /**
             * 新增参数
             */
            long ADD = iusRole + 1;
            /**
             * 编辑参数
             */
            long EDIT = iusRole + 2;
            /**
             * 删除参数
             */
            long REMOVE = iusRole + 3;
            /**
             * 查看
             */
            long QUERY = iusRole + 4;
        }
    }

    /**
     * 车辆监控
     */
    interface VehicleMonitor {
        /**
         * 位置分布
         */
        interface PlaceDisposition {
            /**
             * 新增参数
             */
            long ADD = placeDisposition + 1;
            /**
             * 编辑参数
             */
            long EDIT = placeDisposition + 2;
            /**
             * 删除参数
             */
            long REMOVE = placeDisposition + 3;
            /**
             * 查看
             */
            long QUERY = placeDisposition + 4;
        }

        /**
         * 多屏监控
         */
        interface ScreenMonitor {
            /**
             * 新增参数
             */
            long ADD = screenMonitor + 1;
            /**
             * 编辑参数
             */
            long EDIT = screenMonitor + 2;
            /**
             * 删除参数
             */
            long REMOVE = screenMonitor + 3;
            /**
             * 查看
             */
            long QUERY = screenMonitor + 4;
        }

    }

    /**
     * 调度管理
     */
    interface DispatchManage {
        /**
         * 排班管理
         */
        interface WorkGroupArrange {
            /**
             * 新增参数
             */
            long ADD = workGroupArrange + 1;
            /**
             * 编辑参数
             */
            long EDIT = workGroupArrange + 2;
            /**
             * 删除参数
             */
            long REMOVE = workGroupArrange + 3;
            /**
             * 查看
             */
            long QUERY = workGroupArrange + 4;
        }

        /**
         * 车队点检
         */
        interface TeamTally {
            /**
             * 新增参数
             */
            long ADD = teamTally + 1;
            /**
             * 编辑参数
             */
            long EDIT = teamTally + 2;
            /**
             * 删除参数
             */
            long REMOVE = teamTally + 3;
            /**
             * 查看
             */
            long QUERY = teamTally + 4;
        }
    }

    /**
     * 资源管理
     */
    //资源管理-班组管理
    //资源管理-车辆管理
    //资源管理-人员管理
    //资源管理-车辆型号
    //资源管理-终端管理
    //资源管理-车辆类型
    interface ResourceManage {
        /**
         * 班组管理
         */
        interface WorkGroup {
            /**
             * 新增参数
             */
            long ADD = workGroup + 1;
            /**
             * 编辑参数
             */
            long EDIT = workGroup + 2;
            /**
             * 删除参数
             */
            long REMOVE = workGroup + 3;
            /**
             * 查看
             */
            long QUERY = workGroup + 4;
        }

        /**
         * 车辆管理
         */
        interface VehicleInfo {
            /**
             * 新增参数
             */
            long ADD = vehicleInfo + 1;
            /**
             * 编辑参数
             */
            long EDIT = vehicleInfo + 2;
            /**
             * 删除参数
             */
            long REMOVE = vehicleInfo + 3;
            /**
             * 查看
             */
            long QUERY = vehicleInfo + 4;
        }

        /**
         * 人员管理
         */
        interface WorkPersonnel {
            /**
             * 新增参数
             */
            long ADD = workPersonnel + 1;
            /**
             * 编辑参数
             */
            long EDIT = workPersonnel + 2;
            /**
             * 删除参数
             */
            long REMOVE = workPersonnel + 3;
            /**
             * 查看
             */
            long QUERY = workPersonnel + 4;
        }

        /**
         * 车辆型号
         */
        interface VehicleModel {
            /**
             * 新增参数
             */
            long ADD = vehicleModel + 1;
            /**
             * 编辑参数
             */
            long EDIT = vehicleModel + 2;
            /**
             * 删除参数
             */
            long REMOVE = vehicleModel + 3;
            /**
             * 查看
             */
            long QUERY = vehicleModel + 4;
        }

        /**
         * 终端管理
         */
        interface DeviceInfo {
            /**
             * 新增参数
             */
            long ADD = deviceInfo + 1;
            /**
             * 编辑参数
             */
            long EDIT = deviceInfo + 2;
            /**
             * 删除参数
             */
            long REMOVE = deviceInfo + 3;
            /**
             * 查看
             */
            long QUERY = deviceInfo + 4;
        }

        /**
         * 车辆类型
         */
        interface VehicleType {
            /**
             * 新增参数
             */
            long ADD = vehicleType + 1;
            /**
             * 编辑参数
             */
            long EDIT = vehicleType + 2;
            /**
             * 删除参数
             */
            long REMOVE = vehicleType + 3;
            /**
             * 查看
             */
            long QUERY = vehicleType + 4;
        }

    }


    /**
     * 保养管理
     */
    interface MaintenanceManage {
        /**
         * 保养提醒
         */
        interface MaintenanceRemaind {
            /**
             * 新增参数
             */
            long ADD = maintenanceRemaind + 1;
            /**
             * 编辑参数
             */
            long EDIT = maintenanceRemaind + 2;
            /**
             * 删除参数
             */
            long REMOVE = maintenanceRemaind + 3;
            /**
             * 查看
             */
            long QUERY = maintenanceRemaind + 4;
        }

        /**
         * 保养记录
         */
        interface MaintenanceRecord {
            /**
             * 新增参数
             */
            long ADD = maintenanceRecord + 1;
            /**
             * 编辑参数
             */
            long EDIT = maintenanceRecord + 2;
            /**
             * 删除参数
             */
            long REMOVE = maintenanceRecord + 3;
            /**
             * 查看
             */
            long QUERY = maintenanceRecord + 4;
        }


        /**
         * 保养策略
         */
        interface MaintenanceStrategy {
            /**
             * 新增参数
             */
            long ADD = maintenanceStrategy + 1;
            /**
             * 编辑参数
             */
            long EDIT = maintenanceStrategy + 2;
            /**
             * 删除参数
             */
            long REMOVE = maintenanceStrategy + 3;
            /**
             * 查看
             */
            long QUERY = maintenanceStrategy + 4;
        }

        /**
         * 保养反馈
         */
        interface MaintenanceReturn {
            /**
             * 新增参数
             */
            long ADD = maintenanceReturn + 1;
            /**
             * 编辑参数
             */
            long EDIT = maintenanceReturn + 2;
            /**
             * 删除参数
             */
            long REMOVE = maintenanceReturn + 3;
            /**
             * 查看
             */
            long QUERY = maintenanceReturn + 4;
        }

    }

    /**
     * 报警设置
     */
    interface AlarmMist {
        /**
         * 行车路线
         */
        interface VehicleLine {
            /**
             * 新增参数
             */
            long ADD = vehicleLine + 1;
            /**
             * 编辑参数
             */
            long EDIT = vehicleLine + 2;
            /**
             * 删除参数
             */
            long REMOVE = vehicleLine + 3;
            /**
             * 查看
             */
            long QUERY = vehicleLine + 4;
        }

        /**
         * 电子围栏
         */
        interface VehicleFence {
            /**
             * 新增参数
             */
            long ADD = vehicleFence + 1;
            /**
             * 编辑参数
             */
            long EDIT = vehicleFence + 2;
            /**
             * 删除参数
             */
            long REMOVE = vehicleFence + 3;
            /**
             * 查看
             */
            long QUERY = vehicleFence + 4;
        }

        /**
         * 停车点
         */
        interface VehicleStop {
            /**
             * 新增参数
             */
            long ADD = vehicleStop + 1;
            /**
             * 编辑参数
             */
            long EDIT = vehicleStop + 2;
            /**
             * 删除参数
             */
            long REMOVE = vehicleStop + 3;
            /**
             * 查看
             */
            long QUERY = vehicleStop + 4;
        }
    }


    /**
     * 加油管理
     */
    interface OilManage {
        /**
         * 加油卡管理
         */
        interface OilCard {
            /**
             * 新增参数
             */
            long ADD = oilCard + 1;
            /**
             * 编辑参数
             */
            long EDIT = oilCard + 2;
            /**
             * 删除参数
             */
            long REMOVE = oilCard + 3;
            /**
             * 查看
             */
            long QUERY = oilCard + 4;
        }

        /**
         * 加油记录
         */
        interface OilAddRecord {
            /**
             * 新增参数
             */
            long ADD = oilAddRecord + 1;
            /**
             * 编辑参数
             */
            long EDIT = oilAddRecord + 2;
            /**
             * 删除参数
             */
            long REMOVE = oilAddRecord + 3;
            /**
             * 查看
             */
            long QUERY = oilAddRecord + 4;
        }
    }

    /**
     * 维修管理
     */
    interface RepairManage {
        /**
         * 备件查询
         */
        interface RepairPart {
            /**
             * 新增参数
             */
            long ADD = repairPart + 1;
            /**
             * 编辑参数
             */
            long EDIT = repairPart + 2;
            /**
             * 删除参数
             */
            long REMOVE = repairPart + 3;
            /**
             * 查看
             */
            long QUERY = repairPart + 4;
        }


    }
}
