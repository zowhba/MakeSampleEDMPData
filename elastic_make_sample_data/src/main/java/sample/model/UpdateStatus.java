package sample.model;

import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UpdateStatus {
//	private String id;
	private Date created_time;
	private String stb_id;
	private String cust_type;
	private String model_nm;
	private String team_nm;
	private String sw_nm;
	private String sw_ver;
	private String update_plan_nm;
	private String update_exec_nm;
	private String status;
	private String routing;
	private String error_code;
}

