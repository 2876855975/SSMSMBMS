package com.szxs.entity;


/*
供应商
 */
public class Supplier {

        private  int did;  //供应商id
        private String dname;//供应商名称
        private  String dtel;//供应商电话
        private  String demail;
        private  String daddress;

        public int getDid() {
                return did;
        }

        public void setDid(int did) {
                this.did = did;
        }

        public String getDname() {
                return dname;
        }

        public void setDname(String dname) {
                this.dname = dname;
        }

        public String getDtel() {
                return dtel;
        }

        public void setDtel(String dtel) {
                this.dtel = dtel;
        }

        public String getDemail() {
                return demail;
        }

        public void setDemail(String demail) {
                this.demail = demail;
        }

        public String getDaddress() {
                return daddress;
        }

        public void setDaddress(String daddress) {
                this.daddress = daddress;
        }
}
