package com.zero.customer.service;
/*package cc.richway.base.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cc.richway.base.model.RequestModel;
import cc.richway.base.model.ResponseModel;
import cc.richway.base.model.RichExample;
import cc.richway.base.model.webmodel.FileInfoCommon;
import cc.richway.base.util.SpringUtils;
import cc.richway.base.util.eventutils.Events;
import cc.richway.service.event.EventSendUtil;
import cc.richway.service.transform.BeanUtil;

*//**
 * @author zzj
 *
 * @param <T>
 *//*
@SuppressWarnings("unchecked")
@Service
public class BaseService<T> {
	//换一下，使用@Resource会被was认为未绑定资源，很烦
	@Autowired
	protected SqlSessionTemplate masterSqlSessionTemplate;
	public Mapper<T> mapper;
	public static final String SQLNAME_SEPARATOR = ".";
	*//********************************* sqlid+map方式开始 *********************************************************//*
	*//**
	 * 查询列表 需要传sqlid,默认支持分页，排序需要通过参数传到sqlxml中,sqlxml中可以取到map中的所有参数
	 * 
	 * @param map
	 *            参数：{"sqlid":"必传","appId":"001","appNm":"001",num:1,size:10,
	 *            orderby:order by adcd desc}
	 * @return Page
	 *//*
	public Page<?> selectList(Map<String, Object> map) {
		RequestModel<Map<String, Object>> rm = JSON.toJavaObject(
				new JSONObject(map), RequestModel.class);
		Page<?> p = PageHelper.startPage(rm.getNum().intValue(), rm.getSize()
				.intValue());
		masterSqlSessionTemplate.selectList(rm.getSqlid(), map);
		return p;
	}
	
	public List<T> selectLists(Map<String, Object> map) {
		RequestModel<Map<String, Object>> rm = JSON.toJavaObject(
				new JSONObject(map), RequestModel.class);
		Page<?> p = PageHelper.startPage(rm.getNum().intValue(), rm.getSize()
				.intValue());
		List<T> selectList = masterSqlSessionTemplate.selectList(rm.getSqlid(), map);
		if(map.get(RequestModel.NUM) != null && map.get(RequestModel.SIZE) != null){
			Page<?> p = PageHelper.startPage(((Number)map.get(RequestModel.NUM)).intValue()
					, ((Number)map.get(RequestModel.SIZE)).intValue());
		}
		List<T> selectList = masterSqlSessionTemplate.selectList((String)map.get(RequestModel.SQLID), map);
		return selectList;
	}
	public List<T> selectListsNoPage(Map<String, Object> map) {
		List<T> selectList = masterSqlSessionTemplate.selectList((String) map.get(RequestModel.SQLID), map);
		return selectList;
	}
	*//**
	 * 分页查询
	 * @author Administrator   2015年8月13日
	 * @param map
	 * @return
	 *//*
	public Page<?> selectListsPage(Map<String, Object> map){
		RequestModel<Map<String, Object>> rm = JSON.toJavaObject(
				new JSONObject(map), RequestModel.class);
		Page<?> p = PageHelper.startPage(rm.getNum().intValue(), rm.getSize()
				.intValue());
		
		masterSqlSessionTemplate.selectList(rm.getSqlid(), map);
		return p;
	}
	
	*//**
	 *  分页、排序查询
	 * @author wans   2015年8月13日
	 * @param map
	 * @return
	 *//*
	public Page<?> selectListsPageSort(Map<String, Object> map) {
		RequestModel<Map<String, Object>> rm = JSON.toJavaObject( new JSONObject(map), RequestModel.class);
		
		
		Page<?> p = PageHelper.startPage(rm.getNum().intValue(), rm.getSize().intValue(),rm.getOrderby());
		
		masterSqlSessionTemplate.selectList(rm.getSqlid(), map);
		return p;
	}
	public Page<?> selectListsPageSort(RequestModel rm) {
		
		Page<?> p = PageHelper.startPage(rm.getNum().intValue(), rm.getSize().intValue(),rm.getOrderby());
		
		masterSqlSessionTemplate.selectList(rm.getSqlid(), rm.getParameterMap());
		return p;
	}
	
	public T selectOne(Map<String, Object> map) {
		RequestModel<Map<String, Object>> rm = JSON.toJavaObject(
				new JSONObject(map), RequestModel.class);
		return masterSqlSessionTemplate.selectOne(rm.getSqlid(), map);
	}
	
	
	
	*//**
	 * @param sqlid
	 * @param map
	 * @return List<Map<?, ?>>
	 *//*
	public List<Map<?, ?>> selectListMap(String sqlid,Map<?, ?> map) {
		return masterSqlSessionTemplate.selectList(sqlid, map);
	}
	
	*//**
	 * in查询
	 * 根据一个属性的多个值进行for操作,栗子 {"sqlid":
	 * "cc.richway.framework.persistence.CfgWidgetMapper.getWidgetsByArrayCmptId"
	 * , array:["Base","data_monitor"] } 其中array是xml中的配置
	 * 
	 * @author wans 2015年7月6日
	 * @param body
	 * @return
	 *//*
	public List<Map<?, ?>> selectListByArry(Map<String, Object> map) {
		RequestModel<Map<String, Object>> rm = JSON.toJavaObject(
				new JSONObject(map), RequestModel.class);
		
		// Page<?> p = PageHelper.startPage(rm.getNum().intValue(),
		// rm.getSize().intValue());
		// List<Map<String, Object>> list = rm.getList();
		return masterSqlSessionTemplate.selectList(rm.getSqlid(), map);
	}
	
	*//**
	 * 
	 * @param map
	 *            参数：{"sqlId":"","appId":"001","appNm":"001",num:1,size:10,
	 *            orderby:order by adcd desc}
	 * @return ResponseModel
	 *//*
	 public ResponseModel<?> selectListRes(Map<String, Object> map) {
		 Page<?> p = selectList(map);
		 return ResponseModel.Success(p, p.getTotal());
	 }

	*//**
	 * 删除操作 sqlxml中可以取到map中的所有参数 map
	 * 参数：{"sqlid":"必传","appId":"001","appNm":"001"}
	 * 
	 * @param map
	 * @return
	 *//*
	public int delete(Map<String, Object> map) {
		RequestModel<?> rm = JSON.toJavaObject(new JSONObject(map),
				RequestModel.class);
		return masterSqlSessionTemplate.delete(rm.getSqlid(), map);
	}

	*//**
	 * 修改操作 sqlxml中可以取到map中的所有参数
	 * 
	 * @param map
	 *            参数：{"sqlid":"必传","appId":"001","appNm":"001"}
	 * @return
	 *//*
	public int update(Map<String, Object> map) {
		RequestModel<?> rm = JSON.toJavaObject(new JSONObject(map),
				RequestModel.class);
		return masterSqlSessionTemplate.update(rm.getSqlid(), map);
	}
	
	*//**
	 * 批量更新，使用sqlid和Mapper list数据集合
	 * 
	 * @author wans 2015年7月2日
	 * @param map
	 * @return
	 *//*
	public int updateListByMapper(Map<String, Object> map) {
		RequestModel<?> rm = JSON.toJavaObject(new JSONObject(map),
				RequestModel.class);
		List<?> list = rm.getList();
		for (Object object : list) {
			masterSqlSessionTemplate.update(rm.getSqlid(), object);
		}
		return 1;
	}

	*//**
	 * 新增操作 sqlxml中可以取到map中的所有参数
	 * 
	 * @param map
	 *            参数：{"sqlid":"必传","appId":"001","appNm":"001"}
	 * @return
	 *//*
	public int insert(Map<String, Object> map) {
		RequestModel<?> rm = JSON.toJavaObject(new JSONObject(map),
				RequestModel.class);
//		map.put("crtDt", new Date());
		return masterSqlSessionTemplate.insert(rm.getSqlid(), map);
	}

	*//********************************* sqlid+map方式结束 *********************************************************//*
	
	
	*//********************************* bean+entity方式开始 *********************************************************//*

	*//**
	 * bean：required
	 * 
	 * @param rm
	 * @return Page<T>
	 * @throws Exception
	 *//*
	public Page<T> selectList(RequestModel<T> rm) throws Exception {
		T data = (T) JSON.parseObject(JSON.toJSONString(rm.getData()),
				Class.forName(rm.getBean()));
		Long pageNo = rm.getNum() == null ? null : rm.getNum();
		Long pageSize = rm.getSize() == null ? null : rm.getSize();
		boolean pageSizeZ = false;
		if (pageNo == null && pageSize == null) {
			pageSize = 0l;
			pageNo = 0l;
			pageSizeZ = true;
		}
		Example example = new Example(Class.forName(rm.getBean()));
		Field[] fields = Class.forName(rm.getBean()).getDeclaredFields();
		this.BindParam(example, fields, data);
		Page<T> p = PageHelper.startPage(pageNo.intValue(),
				pageSize.intValue(), true, null, pageSizeZ);
		example.setOrderByClause(rm.getOrderby());
		selectByExample(example);
		return p;
	}

	*//**
	 * @param rm
	 * @return ResponseModel<T>
	 * @throws Exception
	 *//*
	public ResponseModel<T> selectListRes(RequestModel<T> rm) throws Exception {
		Page<T> p = selectList(rm);
		return (ResponseModel<T>) ResponseModel.Success(p, p.getTotal());
	}
	
	*//********************************* bean+entity方式结束 *********************************************************//*


	public List<T> select(T record) {
		mapper = getMapperBean((Class<T>) record.getClass());
		return mapper.select(record);
	}

	public T selectOne(T record) {
		mapper = getMapperBean((Class<T>) record.getClass());
		return (T) mapper.selectOne(record);
	}
	public T selectOne(String statement, Object parameter) {
		return masterSqlSessionTemplate.selectOne(statement, parameter);
	}
	public int selectCount(T record) {
		mapper = getMapperBean((Class<T>) record.getClass());
		return mapper.selectCount(record);
	}

	public T selectByPrimaryKey(T record) {
		mapper = getMapperBean((Class<T>) record.getClass());
		return (T) mapper.selectByPrimaryKey(record);

	}

	public int insert(T record) {
		mapper = getMapperBean((Class<T>) record.getClass());
		try {
			BeanUtil.SetValueByPropertyName("crtDt", new Object[]{new Date()}, record);
			BeanUtil.SetValueByPropertyName("updDt", new Object[]{new Date()}, record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapper.insert(record);
	}

	public String saveOrUpdate(T record) {
		mapper = getMapperBean((Class<T>) record.getClass());
		// (T) mapper.selectOne(record)
		// selectOne(record);
		T selectByPrimaryKey = mapper.selectByPrimaryKey(record);
		if (selectByPrimaryKey == null) {
			mapper.insert(record);
			return "insert";
		} else {
			mapper.updateByPrimaryKey(record);
			return "update";
		}
	}
	
	public int saveOrUpdate(List<T> record){
		int i = 0;
		for (T t : record) {
			if(i==0)
				mapper =  getMapperBean((Class<T>) t.getClass());
			saveOrUpdate(t);
			i++;
		}
		return i;
	}
	
	*//**
	 * 根据主键进行选择性插入，存在就skip，否则insert
	 * 
	 * @author wans 2015年6月30日
	 * @param record
	 * @return
	 *//*
	public String insertNeedCheckForSkip(T record) {
		mapper = getMapperBean((Class<T>) record.getClass());
		T selectByPrimaryKey = mapper.selectByPrimaryKey(record);
		if (selectByPrimaryKey == null) {
			try {
				BeanUtil.SetValueByPropertyName("crtDt", new Object[]{new Date()}, record);
				BeanUtil.SetValueByPropertyName("updDt", new Object[]{new Date()}, record);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mapper.insert(record);
			return "insert";
		} else {
			// mapper.updateByPrimaryKey(record);
			// return "update";
		}
		return "skip";
	}
	*//**
	 * 根据主键进行选择性插入，存在就update，否则insert
	 * 
	 * @author wans 2015年6月30日
	 * @param record
	 * @return
	 *//*
	public String insertNeedCheckForUpdate(T record) {
		mapper = getMapperBean((Class<T>) record.getClass());
		T selectByPrimaryKey = mapper.selectByPrimaryKey(record);
		if (selectByPrimaryKey == null) {
			try {
				BeanUtil.SetValueByPropertyName("crtDt", new Object[]{new Date()}, record);
				BeanUtil.SetValueByPropertyName("updDt", new Object[]{new Date()}, record);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mapper.insert(record);
			return "insert";
		} else {
			 mapper.updateByPrimaryKey(record);
			 return "update";
		}
//		return "skip";
	}

	public int insertBatch(List<T> record) {
		int i = 0;
		for (T t : record) {
			if (i == 0)
				mapper = getMapperBean((Class<T>) t.getClass());
			try {
				BeanUtil.SetValueByPropertyName("crtDt", new Object[]{new Date()}, t);
				BeanUtil.SetValueByPropertyName("updDt", new Object[]{new Date()}, t);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mapper.insert(t);
			i++;
		}
		return i;
	}

	public int insertSelective(T record) {
		mapper = getMapperBean((Class<T>) record.getClass());
		try {
			BeanUtil.SetValueByPropertyName("crtDt", new Object[]{new Date()}, record);
			BeanUtil.SetValueByPropertyName("updDt", new Object[]{new Date()}, record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapper.insertSelective(record);
	}

	public int delete(T record) {
		mapper = getMapperBean((Class<T>) record.getClass());
		return mapper.delete(record);

	}

	public int deleteByPrimaryKey(T record) {
		mapper = getMapperBean((Class<T>) record.getClass());
		return mapper.deleteByPrimaryKey(record);
	}

	public int deleteBatch(List<T> record) {
		int i = 0;
		for (T t : record) {
			if (i == 0)
				mapper = getMapperBean((Class<T>) t.getClass());
			mapper.delete(t);
			i++;
		}
		return i;

	}
	public int deleteBathHashMap(Map<T, T> records) {
		int i = 0;
		for (Map.Entry<T, T> entry : records.entrySet()) {
			if (i == 0)
				mapper = getMapperBean((Class<T>) entry.getValue().getClass());
				mapper.delete(entry.getValue());
				i++;
		}
		return i;

	}
	public int deleteByPrimaryKeyBatch(List<T> record) {
		int i = 0;
		for (T t : record) {
			if (i == 0)
				mapper = getMapperBean((Class<T>) t.getClass());
			mapper.deleteByPrimaryKey(t);
			i++;
		}
		return i;

	}

	public int updateByPrimaryKey(T record) {
		mapper = getMapperBean((Class<T>) record.getClass());
		try {
			BeanUtil.SetValueByPropertyName("updDt", new Object[]{new Date()}, record);
		} catch (Exception e) {
			e.printStackTrace();
		}		return mapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKeyBatch(List<T> record) {
		int i = 0;
		for (T t : record) {
			if (i == 0)
				mapper = getMapperBean((Class<T>) t.getClass());
			try {
				BeanUtil.SetValueByPropertyName("updDt", new Object[]{new Date()}, t);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mapper.updateByPrimaryKey(t);

			i++;
		}
		return i;
	}

	public int updateByPrimaryKeyBatchSelective(List<T> record) {
		int i = 0;
		for (T t : record) {
			if (i == 0)
				mapper = getMapperBean((Class<T>) t.getClass());
			try {
				BeanUtil.SetValueByPropertyName("updDt", new Object[]{new Date()}, t);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mapper.updateByPrimaryKeySelective(t);

			i++;
		}
		return i;
	}
	
	public int updateByPrimaryKeySelective(T record) {
		mapper = getMapperBean((Class<T>) record.getClass());
		try {
			BeanUtil.SetValueByPropertyName("updDt", new Object[]{new Date()}, record);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapper.updateByPrimaryKeySelective(record);

	}

	public int selectCountByExample(Example example) {
		mapper = getMapperBean((Class<T>) example.getEntityClass());
		return mapper.selectCountByExample(example);

	}

	public int deleteByExample(Example example) {
		mapper = getMapperBean((Class<T>) example.getEntityClass());
		return mapper.deleteByExample(example);

	}

	public List<T> selectByExample(Example example) {
		mapper = getMapperBean((Class<T>) example.getEntityClass());
		return mapper.selectByExample(example);

	}
	
	public Page<T> selectByExamplePage(RichExample example) {
		mapper = getMapperBean((Class<T>) example.getEntityClass());
		Page<T> p = PageHelper.startPage(example.getNum(), example.getSize()
				 );
		mapper.selectByExample(example);
		return (Page<T>) p;
		
	}

	public int updateByExampleSelective(T record, Example example) {
		mapper = getMapperBean((Class<T>) example.getEntityClass());
		try {
			BeanUtil.SetValueByPropertyName("updDt", new Object[]{new Date()}, record);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapper.updateByExampleSelective(record, example);

	}

	public int updateByExample(T record, Example example) {
		mapper = getMapperBean((Class<T>) example.getEntityClass());
		try {
			BeanUtil.SetValueByPropertyName("updDt", new Object[]{new Date()}, record);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapper.updateByExample(record, example);

	}

	*//**
	 * 用于查询的时候绑定各个参数是否like和=，用于拼接规则设置
	 * 
	 * @param example
	 * @param fields
	 * @param obj
	 *//*
	public void BindParam(Example example, Field[] fields, Object obj) {
		for (Field field : fields) {
			Object value = BeanUtil
					.GetValueByPropertyName(field.getName(), obj);
			if (value == null)
				continue;
			if ("String".equals(field.getType().getSimpleName())) {
				// 判断字段类型和名称，以便使用like，写得初级，后续完善
				if (field.getName().toLowerCase().indexOf("nm") >= 0
						|| field.getName().indexOf("nt") >= 0) {
					example.createCriteria().andLike(field.getName(),
							"%" + (String) value + "%");
				} else
					example.createCriteria().andEqualTo(field.getName(), value);
			} else
				example.createCriteria().andEqualTo(field.getName(), value);
		}
	}

	public Mapper<T> getMapperBean(Class<T> c) {
			return SpringUtils.getMapperBean(c);
	}

	public List<String> saveFiles(List<FileInfoCommon> listFiles,String strMangCd){
		List<String> list=new ArrayList<String>();
		if(listFiles!=null&&listFiles.size()>0){
			for(FileInfoCommon modCom:listFiles){
				if(modCom!=null){
					String uuid=UUID.randomUUID().toString().replace("-", "");
					modCom.setFileCd(uuid);
					if(strMangCd!=null&&!"".equals(strMangCd))
						modCom.setMangCd(strMangCd.length()>30?strMangCd.substring(0, 30):strMangCd);
					list.add(modCom.getFileCd());
				}
			}
			//事件机制保存文件信息，解耦
			Events.instance().fire("EVENT_FILE_SAVE", JSONArray.toJSONString(listFiles));
		}
		return list;
	}

}*/