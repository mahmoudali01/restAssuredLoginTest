package api.payload;

public class User {
    private String onboard_request;
    private String id;
    private String name;
    private String national_id;
    private String email;
    private String mobile_dial_code;
    private String mobile_number;
    private String last_login_attempt;
    private String last_login;
    private String birth_date;
    private String gender;
    private String preferred_language;
    private String birth_country;
    private String residence_country;
    private String source_of_income;
    private String profession;
    private Boolean is_owner;
    private Boolean is_contact_user;
    private Boolean is_active;
    private String created_at;
    private String updated_at;
    private Merchant merchant;
    private EKYC ekyc;

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public EKYC getEkyc() {
        return ekyc;
    }

    public void setEkyc(EKYC ekyc) {
        this.ekyc = ekyc;
    }



    public String getOnboard_request() {
        return onboard_request;
    }

    public void setOnboard_request(String onboard_request) {
        this.onboard_request = onboard_request;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNational_id() {
        return national_id;
    }

    public void setNational_id(String national_id) {
        this.national_id = national_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_dial_code() {
        return mobile_dial_code;
    }

    public void setMobile_dial_code(String mobile_dial_code) {
        this.mobile_dial_code = mobile_dial_code;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getLast_login_attempt() {
        return last_login_attempt;
    }

    public void setLast_login_attempt(String last_login_attempt) {
        this.last_login_attempt = last_login_attempt;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPreferred_language() {
        return preferred_language;
    }

    public void setPreferred_language(String preferred_language) {
        this.preferred_language = preferred_language;
    }

    public String getBirth_country() {
        return birth_country;
    }

    public void setBirth_country(String birth_country) {
        this.birth_country = birth_country;
    }

    public String getResidence_country() {
        return residence_country;
    }

    public void setResidence_country(String residence_country) {
        this.residence_country = residence_country;
    }

    public String getSource_of_income() {
        return source_of_income;
    }

    public void setSource_of_income(String source_of_income) {
        this.source_of_income = source_of_income;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Boolean getIs_owner() {
        return is_owner;
    }

    public void setIs_owner(Boolean is_owner) {
        this.is_owner = is_owner;
    }

    public Boolean getIs_contact_user() {
        return is_contact_user;
    }

    public void setIs_contact_user(Boolean is_contact_user) {
        this.is_contact_user = is_contact_user;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }



}
