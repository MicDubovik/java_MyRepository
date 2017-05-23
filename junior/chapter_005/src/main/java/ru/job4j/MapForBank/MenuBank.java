package ru.job4j.MapForBank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * MenuBank
 */
public class MenuBank {
    /**
     * InputBank.
     */
    private InputBank input;
    /**
     * Bank.
     */
    private Bank bank;
    /**
     * List<UserActionBank>.
     */
    private List<UserActionBank> actions = new ArrayList<>();
    /**
     * HashMap<Integer, UserActionBank>.
     */
    private HashMap<Integer, UserActionBank> possibleAction = new HashMap<>();

    /**
     * Constructor..
     * @param input
     * @param bank
     */
    public MenuBank(InputBank input, Bank bank) {
        this.input = input;
        this.bank = bank;
    }

    /**
     * FillActions.
     * @return
     */
    public HashMap<Integer, UserActionBank> fillActions() {
        this.actions.add(new AddUser());
        this.actions.add(new DeleteUse());
        this.actions.add(new AddAccountToUser());
        this.actions.add(new DeleteAccountFromUser());
        this.actions.add(new TransferMoney());
        this.actions.add(new ShowAllUsers());


        for (int i = 0; i < actions.size(); i++) {
            this.possibleAction.put(actions.get(i).key(), actions.get(i));
        }
        return possibleAction;
    }

    /**
     * Select by key.
     * @param key
     */
    public void select(int key) {

        this.possibleAction.get(key).execute(this.input, this.bank);

    }

    /**
     * Show.
     */
    public void show() {
        for (UserActionBank action : actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Show user.
     * @param user
     */
    private void showUser(User user) {
        System.out.println(user.getName() + " " + user.getPassport() + " " + user.getAccounts().size());
    }

    /**
     * Add user.
     */
    private class AddUser extends BaseActionBank {

        /**
         * Информация о методе.
         */
        AddUser() {
            super("Add the new User.");
        }

        /**
         * Номер метода.
         *
         * @return number.
         */
        public int key() {
            return 0;
        }

        /**
         * Действие метода.
         *
         * @param input input.
         * @param bank  bank.
         */
        public void execute(InputBank input, Bank bank) {
            String name = input.ask("Please enter the User name: ");
            String passport = input.ask("Please enter the User passport: ");
            bank.addUser(new User(name, passport));

        }

    }

    /**
     * class DeleteUse
     */
    private class DeleteUse extends BaseActionBank {

        /**
         * Информация о методе.
         */
        DeleteUse() {
            super("Delete  User.");
        }

        /**
         * Номер метода.
         *
         * @return number.
         */
        public int key() {
            return 1;
        }

        /**
         * Действие метода.
         *
         * @param input input.
         * @param bank  bank.
         */
        public void execute(InputBank input, Bank bank) {
            String name = input.ask("Please enter the User name: ");
            String passport = input.ask("Please enter the User passport: ");
            bank.deleteUser(new User(name, passport));

        }

    }

    private class AddAccountToUser extends BaseActionBank {

        /**
         * Информация о методе.
         */
        AddAccountToUser() {
            super("Add account to User.");
        }

        /**
         * Номер метода.
         *
         * @return number.
         */
        public int key() {
            return 2;
        }

        /**
         * Действие метода.
         *
         * @param input input.
         * @param bank  bank.
         */
        public void execute(InputBank input, Bank bank) {

            String passport = input.ask("Please enter the User passport: ");
            String value = input.ask("Please enter the User account value:");
            String requisites = input.ask("Please enter the User account requisites:");

            for (int i = 0; i < bank.listUsers.size(); i++) {
                if (bank.listUsers.get(i).getPassport().equals(passport)) {

                    bank.addAccountToUser(bank.listUsers.get(i), new Account(Integer.parseInt(value), Integer.parseInt(requisites)));
                }
            }
        }

    }

    private class DeleteAccountFromUser extends BaseActionBank {

        /**
         * Информация о методе.
         */
        DeleteAccountFromUser() {
            super("Delete account from User.");
        }

        /**
         * Номер метода.
         *
         * @return number.
         */
        public int key() {
            return 3;
        }

        /**
         * Действие метода.
         *
         * @param input input.
         * @param bank  bank.
         */
        public void execute(InputBank input, Bank bank) {

            String passport = input.ask("Please enter the User passport: ");
            String requisites = input.ask("Please enter the User account requisites:");
            bank.deleteAccountFromUser(new User(passport), new Account(Integer.parseInt(requisites)));

        }

    }

    private class TransferMoney extends BaseActionBank {

        /**
         * Информация о методе.
         */
        TransferMoney() {
            super("Transfer money .");
        }

        /**
         * Номер метода.
         *
         * @return number.
         */
        public int key() {
            return 4;
        }

        /**
         * Действие метода.
         *
         * @param input input.
         * @param bank  bank.
         */
        public void execute(InputBank input, Bank bank) {
            String srcPassport = input.ask("Please enter the source User passport : ");
            String srcRequisites = input.ask("Please enter the source account : ");
            String destPassport = input.ask("Please enter the destination User passport : ");
            String destRequisites = input.ask("Please enter the destination account requisites:");
            String value = input.ask("Please enter the value for transfer : ");
            User srcUser = null;
            User destUser = null;
            Account srcAcc = null;
            Account destAcc = null;
            for (int i = 0; i < bank.listUsers.size(); i++) {
                if (bank.listUsers.get(i).getPassport().equals(srcPassport)) {
                    srcUser = bank.listUsers.get(i);
                }
                if (bank.listUsers.get(i).getPassport().equals(destPassport)) {
                    destUser = bank.listUsers.get(i);
                }
            }

            for (int i = 0; i < srcUser.getAccounts().size(); i++) {

                if (srcUser.getAccounts().get(i).getRequisites() == Integer.parseInt(srcRequisites)) {
                    srcAcc = srcUser.getAccounts().get(i);
                    break;
                }
            }
            for (int i = 0; i < destUser.getAccounts().size(); i++) {

                if (destUser.getAccounts().get(i).getRequisites() == Integer.parseInt(destRequisites)) {
                    destAcc = destUser.getAccounts().get(i);
                    break;
                }
            }
            bank.transferMoney(srcUser, srcAcc, destUser, destAcc, Integer.parseInt(value));
        }
    }

    private class ShowAllUsers extends BaseActionBank {

        /**
         * Информация о методе.
         */
        ShowAllUsers() {
            super("Show all Users.");
        }

        /**
         * Номер метода.
         *
         * @return number.
         */
        public int key() {
            return 5;
        }

        /**
         * Действие метода.
         *
         * @param input input.
         * @param bank  bank.
         */
        public void execute(InputBank input, Bank bank) {

            bank.showAllUsers(bank.listUsers);

        }

    }


}
