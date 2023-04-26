package api.payload;

public class Merchant {
    private String id;
    private String reference;
    private int business_type;
    private String business_reference;
    private String solo_id;
    private String business_name;
    private String business_name_localized;
    private String commercial_registration;
    private String commercial_registration_expiration;
    private String unified_national_number;
    private int mcc;
    private Boolean settlement_enabled;
    private String settlement_disabled_reason;
    private int total_terminals;
    private int active_terminals;
    private String beneficiary_name;
    private String mada_fee;
    private String credit_card_fee;
    private String amex_fee;
    private Boolean is_active;
    private Boolean is_approved;
    private String created_at;
    private String updated_at;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(int business_type) {
        this.business_type = business_type;
    }

    public String getBusiness_reference() {
        return business_reference;
    }

    public void setBusiness_reference(String business_reference) {
        this.business_reference = business_reference;
    }

    public String getSolo_id() {
        return solo_id;
    }

    public void setSolo_id(String solo_id) {
        this.solo_id = solo_id;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getBusiness_name_localized() {
        return business_name_localized;
    }

    public void setBusiness_name_localized(String business_name_localized) {
        this.business_name_localized = business_name_localized;
    }

    public String getCommercial_registration() {
        return commercial_registration;
    }

    public void setCommercial_registration(String commercial_registration) {
        this.commercial_registration = commercial_registration;
    }

    public String getCommercial_registration_expiration() {
        return commercial_registration_expiration;
    }

    public void setCommercial_registration_expiration(String commercial_registration_expiration) {
        this.commercial_registration_expiration = commercial_registration_expiration;
    }

    public String getUnified_national_number() {
        return unified_national_number;
    }

    public void setUnified_national_number(String unified_national_number) {
        this.unified_national_number = unified_national_number;
    }

    public int getMcc() {
        return mcc;
    }

    public void setMcc(int mcc) {
        this.mcc = mcc;
    }

    public Boolean getSettlement_enabled() {
        return settlement_enabled;
    }

    public void setSettlement_enabled(Boolean settlement_enabled) {
        this.settlement_enabled = settlement_enabled;
    }

    public String getSettlement_disabled_reason() {
        return settlement_disabled_reason;
    }

    public void setSettlement_disabled_reason(String settlement_disabled_reason) {
        this.settlement_disabled_reason = settlement_disabled_reason;
    }

    public int getTotal_terminals() {
        return total_terminals;
    }

    public void setTotal_terminals(int total_terminals) {
        this.total_terminals = total_terminals;
    }

    public int getActive_terminals() {
        return active_terminals;
    }

    public void setActive_terminals(int active_terminals) {
        this.active_terminals = active_terminals;
    }

    public String getBeneficiary_name() {
        return beneficiary_name;
    }

    public void setBeneficiary_name(String beneficiary_name) {
        this.beneficiary_name = beneficiary_name;
    }

    public String getMada_fee() {
        return mada_fee;
    }

    public void setMada_fee(String mada_fee) {
        this.mada_fee = mada_fee;
    }

    public String getCredit_card_fee() {
        return credit_card_fee;
    }

    public void setCredit_card_fee(String credit_card_fee) {
        this.credit_card_fee = credit_card_fee;
    }

    public String getAmex_fee() {
        return amex_fee;
    }

    public void setAmex_fee(String amex_fee) {
        this.amex_fee = amex_fee;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Boolean getIs_approved() {
        return is_approved;
    }

    public void setIs_approved(Boolean is_approved) {
        this.is_approved = is_approved;
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
