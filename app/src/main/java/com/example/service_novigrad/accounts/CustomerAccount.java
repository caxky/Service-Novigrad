class CustomerAccount extends Account{

    //Constructor
    public CustomerAccount(String username, String password, String firstName, String lastName){
        this.accountType = 0;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Class Methods
    public void searchBranch(){}

    public void purchaseService(){}

    public void fillService(){}

    public void rateExperience(){}
}