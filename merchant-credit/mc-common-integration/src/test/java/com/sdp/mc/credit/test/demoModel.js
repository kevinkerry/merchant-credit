{
    "types": [
        {
            "code": "Applicant basic information",
            "desc": "申请人基础信息",
            "items": [
                {
                    "code": "1",
                    "desc": "年龄",
                    "inputType": "Enum",
                    "isNeed": "true",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "30-45岁"
                        },
                        {
                            "code": "2",
                            "desc": "其他"
                        }
                    ]
                },
                {
                    "code": "2",
                    "desc": "婚姻",
                    "inputType": "EnumAttachment",
                    "isNeed": "true",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "户口本或结婚证能够证明已婚"
                        },
                        {
                            "code": "2",
                            "desc": "无"
                        }
                    ]
                },
                {
                    "code": "3",
                    "desc": "子女",
                    "inputType": "EnumAttachment",
                    "isNeed": "true",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "户口本或出生证明能够证明已育"
                        },
                        {
                            "code": "2",
                            "desc": "无"
                        }
                    ]
                },
                {
                    "code": "4",
                    "desc": "学历",
                    "inputType": "Enum",
                    "isNeed": "true",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "本科及以上学历"
                        },
                        {
                            "code": "2",
                            "desc": "无"
                        }
                    ]
                },
                {
                    "code": "5",
                    "desc": "配偶工作单位",
                    "inputType": "Enum",
                    "isNeed": "true",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "配否拥有合法稳定工作且非该申请企业员工"
                        },
                        {
                            "code": "2",
                            "desc": "无"
                        }
                    ]
                }
            ]
        },
        {
            "code": "Creditreport",
            "desc": "申请人征信报告",
            "items": [
                {
                    "code": "a",
                    "desc": "申请人征信记录完整性",
                    "inputType": "EnumAttachment",
                    "isNeed": "true",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "拥有征信记录"
                        },
                        {
                            "code": "2",
                            "desc": "拥有征信记录+信用卡负债记录"
                        },
                        {
                            "code": "3",
                            "desc": "拥有征信记录+信用卡负债记录+房贷记录"
                        },
                        {
                            "code": "4",
                            "desc": "拥有征信记录+信用卡负债记录+房贷记录+其他贷款记录"
                        }
                    ]
                },
                {
                    "code": "b",
                    "desc": "征信记录合理/稳定性",
                    "inputType": "EnumAttachment",
                    "isNeed": "true",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "近期查询记录正常"
                        },
                        {
                            "code": "2",
                            "desc": "近期查询记录正常+雇佣关系稳定"
                        },
                        {
                            "code": "3",
                            "desc": "近期查询记录正常+雇佣关系稳定+住宅信息稳定"
                        }
                    ]
                },
                {
                    "code": "c",
                    "desc": "申请人负债可控性",
                    "inputType": "EnumAttachment",
                    "isNeed": "true",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "资产负债率（根据资产+商户交易规模）：高（50%以上）"
                        },
                        {
                            "code": "2",
                            "desc": "资产负债率（根据资产+商户交易规模）：中（30-50%）"
                        },
                        {
                            "code": "3",
                            "desc": "资产负债率（根据资产+商户交易规模）：低（30%及以下）"
                        }
                    ]
                },
                {
                    "code": "d",
                    "desc": "申请人还款记录",
                    "inputType": "EnumAttachment",
                    "isNeed": "true",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "一般"
                        },
                        {
                            "code": "2",
                            "desc": "良好"
                        },
                        {
                            "code": "3",
                            "desc": "优秀"
                        }
                    ]
                },
                {
                    "code": "e",
                    "desc": "配偶征信报告",
                    "inputType": "EnumAttachment",
                    "isNeed": "true",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "无/极差"
                        },
                        {
                            "code": "2",
                            "desc": "一般"
                        },
                        {
                            "code": "3",
                            "desc": "良好"
                        },
                        {
                            "code": "4",
                            "desc": "优"
                        }
                    ]
                }
            ]
        },
        {
            "code": "Extra points project",
            "desc": "商户加分项目",
            "items": [
                {
                    "code": "1",
                    "desc": "配偶在职收入证明",
                    "inputType": "EnumAttachment",
                    "isNeed": "false",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "提供工作收入证明且非该申请企业且认定为有效"
                        },
                        {
                            "code": "2",
                            "desc": "无"
                        }
                    ]
                },
                {
                    "code": "2",
                    "desc": "学历证明材料",
                    "inputType": "EnumAttachment",
                    "isNeed": "false",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "提供全日制硕士研究生及以上学历证明"
                        },
                        {
                            "code": "2",
                            "desc": "无"
                        }
                    ]
                },
                {
                    "code": "3",
                    "desc": "非人行征信报告",
                    "inputType": "EnumAttachment",
                    "isNeed": "false",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "提供芝麻信用评分报告等且认定为有效"
                        },
                        {
                            "code": "2",
                            "desc": "无"
                        }
                    ]
                },
                {
                    "code": "4",
                    "desc": "户籍信息",
                    "inputType": "EnumAttachment",
                    "isNeed": "false",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "企业所在地与申请人户籍所在地相同"
                        },
                        {
                            "code": "2",
                            "desc": "无"
                        }
                    ]
                },
                {
                    "code": "5",
                    "desc": "其他",
                    "inputType": "EnumAttachment",
                    "isNeed": "false",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "其他我司认可的资信证明，如社保记录、公积金缴存记录等"
                        },
                        {
                            "code": "2",
                            "desc": "无"
                        }
                    ]
                }
            ]
        },
        {
            "code": "Financial information",
            "desc": "申请人财务信息",
            "items": [
                {
                    "code": "1",
                    "desc": "申请企业出资证明",
                    "inputType": "EnumAttachment",
                    "isNeed": "false",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "有且可信"
                        },
                        {
                            "code": "2",
                            "desc": "无"
                        }
                    ]
                },
                {
                    "code": "2",
                    "desc": "房屋价值",
                    "inputType": "EnumAttachment",
                    "isNeed": "false",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "一线城市自由住房"
                        },
                        {
                            "code": "2",
                            "desc": "其他城市"
                        },
                        {
                            "code": "3",
                            "desc": "无"
                        }
                    ]
                },
                {
                    "code": "3",
                    "desc": "自有汽车",
                    "inputType": "EnumAttachment",
                    "isNeed": "false",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "出厂价值15万"
                        },
                        {
                            "code": "2",
                            "desc": "出厂价值15万+限购城市牌照"
                        },
                        {
                            "code": "3",
                            "desc": "无"
                        }
                    ]
                },
                {
                    "code": "4",
                    "desc": "货币性资产",
                    "inputType": "EnumAttachment",
                    "isNeed": "false",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "10万元及以上的有效存款证明"
                        },
                        {
                            "code": "2",
                            "desc": "无"
                        }
                    ]
                },
                {
                    "code": "5",
                    "desc": "有价证券",
                    "inputType": "EnumAttachment",
                    "isNeed": "false",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "持有期超过1个月且买入或当前价值超过5万元及以上有价证券"
                        },
                        {
                            "code": "2",
                            "desc": "无"
                        }
                    ]
                },
                {
                    "code": "6",
                    "desc": "银行交易流水",
                    "inputType": "EnumAttachment",
                    "isNeed": "false",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "城商行及以上银行机构的借记卡交易流水证明且认定为有效"
                        },
                        {
                            "code": "2",
                            "desc": "无"
                        }
                    ]
                }
            ]
        },
        {
            "code": "MerchantBaseInfo",
            "desc": "商户基本信息",
            "items": [
                {
                    "code": "2",
                    "desc": "企业注册资本",
                    "inputType": "Enum",
                    "isNeed": "true",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "1-10万"
                        },
                        {
                            "code": "2",
                            "desc": "10-50万"
                        },
                        {
                            "code": "3",
                            "desc": "50-100万"
                        },
                        {
                            "code": "4",
                            "desc": "100万以上"
                        },
                        {
                            "code": "5",
                            "desc": "实收资本达到50万"
                        }
                    ]
                },
                {
                    "code": "5",
                    "desc": "经营场地信息",
                    "inputType": "EnumAttachment",
                    "isNeed": "true",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "一般租赁/民宅"
                        },
                        {
                            "code": "2",
                            "desc": "一般写字楼"
                        },
                        {
                            "code": "3",
                            "desc": "高级写字楼"
                        }
                    ]
                },
                {
                    "code": "6",
                    "desc": "资料完整程度",
                    "inputType": "EnumAttachment",
                    "isNeed": "true",
                    "inputOwner": "Merchant",
                    "enums": [
                        {
                            "code": "1",
                            "desc": "营业执照"
                        },
                        {
                            "code": "2",
                            "desc": "营业执照+组织机构代码证"
                        },
                        {
                            "code": "3",
                            "desc": "营业执照+组织机构代码证+税务登记证"
                        },
                        {
                            "code": "4",
                            "desc": "营业执照+组织机构代码证+银行开户许可证"
                        }
                    ]
                }
            ]
        }
    ]
}