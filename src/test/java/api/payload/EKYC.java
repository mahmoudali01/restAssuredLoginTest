package api.payload;

public class EKYC {
    private Boolean is_suspicious;
    private Boolean is_completed;
    private Boolean is_mobile_number_verified;
    private Boolean is_national_id_verified;
    private Boolean is_commercial_registration_verified;
    private Boolean is_email_verified;

    public Boolean getIs_suspicious() {
        return is_suspicious;
    }

    public void setIs_suspicious(Boolean is_suspicious) {
        this.is_suspicious = is_suspicious;
    }

    public Boolean getIs_completed() {
        return is_completed;
    }

    public void setIs_completed(Boolean is_completed) {
        this.is_completed = is_completed;
    }

    public Boolean getIs_mobile_number_verified() {
        return is_mobile_number_verified;
    }

    public void setIs_mobile_number_verified(Boolean is_mobile_number_verified) {
        this.is_mobile_number_verified = is_mobile_number_verified;
    }

    public Boolean getIs_national_id_verified() {
        return is_national_id_verified;
    }

    public void setIs_national_id_verified(Boolean is_national_id_verified) {
        this.is_national_id_verified = is_national_id_verified;
    }

    public Boolean getIs_commercial_registration_verified() {
        return is_commercial_registration_verified;
    }

    public void setIs_commercial_registration_verified(Boolean is_commercial_registration_verified) {
        this.is_commercial_registration_verified = is_commercial_registration_verified;
    }

    public Boolean getIs_email_verified() {
        return is_email_verified;
    }

    public void setIs_email_verified(Boolean is_email_verified) {
        this.is_email_verified = is_email_verified;
    }
}
