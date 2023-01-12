package com.vuklorr.fileshared.entity;

import lombok.Data;

@Data
public class PrivilegeOfOperation {
    private int idPrivilege;
    private int idTypeOfOperation;

    public PrivilegeOfOperation(int idPrivilege, int idTypeOfOperation) {
        this.idPrivilege = idPrivilege;
        this.idTypeOfOperation = idTypeOfOperation;
    }
}