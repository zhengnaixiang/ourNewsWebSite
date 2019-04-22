package com.qf.userInfo.pojo;

/**
 * 激活关联
 */
public class Activation {

    int activation_id;
    int user_id;
    int activation_key;
    String log_date;

    @Override
    public String toString() {
        return "Activation{" +
                "activation_id=" + activation_id +
                ", user_id=" + user_id +
                ", activation_key=" + activation_key +
                ", log_date='" + log_date + '\'' +
                '}';
    }

    public Activation() {
    }

    public Activation(int user_id, int key) {
        this.user_id = user_id;
        this.activation_key = key;
    }

    public int getActivation_id() {
        return activation_id;
    }

    public void setActivation_id(int activation_id) {
        this.activation_id = activation_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getActivation_key() {
        return activation_key;
    }

    public void setActivation_key(int activation_key) {
        this.activation_key = activation_key;
    }

    public String getLog_date() {
        return log_date;
    }

    public void setLog_date(String log_date) {
        this.log_date = log_date;
    }
}
