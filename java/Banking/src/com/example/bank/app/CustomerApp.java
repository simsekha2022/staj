package com.example.bank.app;

import java.util.List;
import java.util.function.Consumer;

import com.example.bank.proje.Account;
import com.example.bank.proje.Customer;
import com.example.bank.proje.Bank;

public class CustomerApp {
    public static void main(String[] args) {

        Customer jack = new Customer("1", "Jack Bauer");

        Account acc1 = new Account("TR1", 15000);
        Account acc2 = new Account("TR2", 10000);
        Account acc3 = new Account("TR3", 10000);

        jack.addAccount(acc1);
        jack.addAccount(acc2);
        jack.addAccount(acc3);

        System.out.println("Hesap sayısı: " + jack.getNumberOfAccount());
        Consumer<Account> withdraw45k = acc -> acc.withdraw(5000);
        Consumer<Account> withdraw5k = acc -> acc.withdraw(0);

        jack.getAccount("TR1").ifPresentOrElse(
                withdraw45k.andThen(withdraw5k), () -> System.out.println("Böyle bir hesap bulunamadı"));

        jack.removeAccount("TR2").ifPresentOrElse(acc -> System.out.println(acc.getIban() + " Ibanlı hesap silindi."), () -> System.out.println("Silmek istediğiniz hesap bulunamadı"));
        System.out.println("Hesap sayısı: " + jack.getNumberOfAccount());

        for (String account : jack.toArray()) {
            System.out.println("Hesap ismi: " + account + " Bakiye: " + jack.getAccount(account).get().getBalance());
            
        }
        System.out.println("Hesaplarınızın toplam bakiyesi: " + jack.getBalance());
        

    }
    
}