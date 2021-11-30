package com.utilivisor.challenge.datacollection;

import org.springframework.format.annotation.DateTimeFormat;

public class PointHistory {

	    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
		private String timeStamp;
		private String _01_15B_2331_SHERIDAN_CONDMT;
	    private String _02_67B_RYAN_HALL_CHW_TON_HR;
	    private String _01_19B_2347_SHERIDAN_CONDMT;
	    private String _01_47B_717_UNIVERSITY_CONDMT;
	    private String _02_62D_SLIVKA_CON_MT_KLBS;

	    public PointHistory(String timeStamp, String first, String second, String third, String fourth, String fifth ) {
	        this.timeStamp = timeStamp;
	        this._01_15B_2331_SHERIDAN_CONDMT = first;
	        this._02_67B_RYAN_HALL_CHW_TON_HR = second;
	        this._01_19B_2347_SHERIDAN_CONDMT = third;
	        this._01_47B_717_UNIVERSITY_CONDMT = fourth;
	        this._02_62D_SLIVKA_CON_MT_KLBS = fifth;
	    }
	    
	    //getters


		public String getTimeStamp() {
			return timeStamp;
		}
	    
	    public String get_01_15B_2331_SHERIDAN_CONDMT() {
			return _01_15B_2331_SHERIDAN_CONDMT;
		}

		public String get_02_67B_RYAN_HALL_CHW_TON_HR() {
			return _02_67B_RYAN_HALL_CHW_TON_HR;
		}

		public String get_01_19B_2347_SHERIDAN_CONDMT() {
			return _01_19B_2347_SHERIDAN_CONDMT;
		}

		public String get_01_47B_717_UNIVERSITY_CONDMT() {
			return _01_47B_717_UNIVERSITY_CONDMT;
		}

		public String get_02_62D_SLIVKA_CON_MT_KLBS() {
			return _02_62D_SLIVKA_CON_MT_KLBS;
		}
		
		// setters
		public void setTimeStamp(String timeStamp) {
			this.timeStamp = timeStamp;
		}

		public void set_01_15B_2331_SHERIDAN_CONDMT(String _01_15b_2331_SHERIDAN_CONDMT) {
			_01_15B_2331_SHERIDAN_CONDMT = _01_15b_2331_SHERIDAN_CONDMT;
		}

		public void set_02_67B_RYAN_HALL_CHW_TON_HR(String _02_67b_RYAN_HALL_CHW_TON_HR) {
			_02_67B_RYAN_HALL_CHW_TON_HR = _02_67b_RYAN_HALL_CHW_TON_HR;
		}

		public void set_01_19B_2347_SHERIDAN_CONDMT(String _01_19b_2347_SHERIDAN_CONDMT) {
			_01_19B_2347_SHERIDAN_CONDMT = _01_19b_2347_SHERIDAN_CONDMT;
		}

		public void set_01_47B_717_UNIVERSITY_CONDMT(String _01_47b_717_UNIVERSITY_CONDMT) {
			_01_47B_717_UNIVERSITY_CONDMT = _01_47b_717_UNIVERSITY_CONDMT;
		}

		public void set_02_62D_SLIVKA_CON_MT_KLBS(String _02_62d_SLIVKA_CON_MT_KLBS) {
			_02_62D_SLIVKA_CON_MT_KLBS = _02_62d_SLIVKA_CON_MT_KLBS;
		}
};

