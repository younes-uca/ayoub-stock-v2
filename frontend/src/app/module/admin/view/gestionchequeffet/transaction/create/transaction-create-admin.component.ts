import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {TransactionAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TransactionAdmin.service';
import {TransactionDto} from 'src/app/controller/model/gestionchequeffet/Transaction.model';
import {TransactionCriteria} from 'src/app/controller/criteria/gestionchequeffet/TransactionCriteria.model';
import {TypeTransactionDto} from 'src/app/controller/model/gestionchequeffet/TypeTransaction.model';
import {TypeTransactionAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeTransactionAdmin.service';
import {InstrumentDto} from 'src/app/controller/model/chequeffet/Instrument.model';
import {InstrumentAdminService} from 'src/app/controller/service/admin/chequeffet/InstrumentAdmin.service';
import {CompteDto} from 'src/app/controller/model/gestionchequeffet/Compte.model';
import {CompteAdminService} from 'src/app/controller/service/admin/gestionchequeffet/CompteAdmin.service';
@Component({
  selector: 'app-transaction-create-admin',
  templateUrl: './transaction-create-admin.component.html'
})
export class TransactionCreateAdminComponent extends AbstractCreateController<TransactionDto, TransactionCriteria, TransactionAdminService>  implements OnInit {



   private _validTransactionDateTransaction = true;
   private _validTransactionInstrument = true;
   private _validTransactionCompte = true;
    private _validTypeTransactionLibelle = true;
    private _validTypeTransactionCode = true;
    private _validCompteNumeroCompte = true;
    private _validCompteBanque = true;
    private _validCompteProprietaire = true;

    constructor( private transactionService: TransactionAdminService , private typeTransactionService: TypeTransactionAdminService, private instrumentService: InstrumentAdminService, private compteService: CompteAdminService) {
        super(transactionService);
    }

    ngOnInit(): void {
        this.typeTransaction = new TypeTransactionDto();
        this.typeTransactionService.findAll().subscribe((data) => this.typeTransactions = data);
        this.instrument = new InstrumentDto();
        this.instrumentService.findAll().subscribe((data) => this.instruments = data);
        this.compte = new CompteDto();
        this.compteService.findAll().subscribe((data) => this.comptes = data);
    }





    public setValidation(value: boolean){
        this.validTransactionDateTransaction = value;
        this.validTransactionInstrument = value;
        this.validTransactionCompte = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTransactionDateTransaction();
        this.validateTransactionInstrument();
        this.validateTransactionCompte();
    }

    public validateTransactionDateTransaction(){
        if (this.stringUtilService.isEmpty(this.item.dateTransaction)) {
        this.errorMessages.push('Date transaction non valide');
        this.validTransactionDateTransaction = false;
        } else {
            this.validTransactionDateTransaction = true;
        }
    }
    public validateTransactionInstrument(){
        if (this.stringUtilService.isEmpty(this.item.instrument)) {
        this.errorMessages.push('Instrument non valide');
        this.validTransactionInstrument = false;
        } else {
            this.validTransactionInstrument = true;
        }
    }
    public validateTransactionCompte(){
        if (this.stringUtilService.isEmpty(this.item.compte)) {
        this.errorMessages.push('Compte non valide');
        this.validTransactionCompte = false;
        } else {
            this.validTransactionCompte = true;
        }
    }


    public async openCreateTypeTransaction(typeTransaction: string) {
    const isPermistted = await this.roleService.isPermitted('TypeTransaction', 'add');
    if(isPermistted) {
         this.typeTransaction = new TypeTransactionDto();
         this.createTypeTransactionDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateCompte(compte: string) {
    const isPermistted = await this.roleService.isPermitted('Compte', 'add');
    if(isPermistted) {
         this.compte = new CompteDto();
         this.createCompteDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get typeTransaction(): TypeTransactionDto {
        return this.typeTransactionService.item;
    }
    set typeTransaction(value: TypeTransactionDto) {
        this.typeTransactionService.item = value;
    }
    get typeTransactions(): Array<TypeTransactionDto> {
        return this.typeTransactionService.items;
    }
    set typeTransactions(value: Array<TypeTransactionDto>) {
        this.typeTransactionService.items = value;
    }
    get createTypeTransactionDialog(): boolean {
       return this.typeTransactionService.createDialog;
    }
    set createTypeTransactionDialog(value: boolean) {
        this.typeTransactionService.createDialog= value;
    }
    get compte(): CompteDto {
        return this.compteService.item;
    }
    set compte(value: CompteDto) {
        this.compteService.item = value;
    }
    get comptes(): Array<CompteDto> {
        return this.compteService.items;
    }
    set comptes(value: Array<CompteDto>) {
        this.compteService.items = value;
    }
    get createCompteDialog(): boolean {
       return this.compteService.createDialog;
    }
    set createCompteDialog(value: boolean) {
        this.compteService.createDialog= value;
    }
    get instrument(): InstrumentDto {
        return this.instrumentService.item;
    }
    set instrument(value: InstrumentDto) {
        this.instrumentService.item = value;
    }
    get instruments(): Array<InstrumentDto> {
        return this.instrumentService.items;
    }
    set instruments(value: Array<InstrumentDto>) {
        this.instrumentService.items = value;
    }
    get createInstrumentDialog(): boolean {
       return this.instrumentService.createDialog;
    }
    set createInstrumentDialog(value: boolean) {
        this.instrumentService.createDialog= value;
    }



    get validTransactionDateTransaction(): boolean {
        return this._validTransactionDateTransaction;
    }

    set validTransactionDateTransaction(value: boolean) {
         this._validTransactionDateTransaction = value;
    }
    get validTransactionInstrument(): boolean {
        return this._validTransactionInstrument;
    }

    set validTransactionInstrument(value: boolean) {
         this._validTransactionInstrument = value;
    }
    get validTransactionCompte(): boolean {
        return this._validTransactionCompte;
    }

    set validTransactionCompte(value: boolean) {
         this._validTransactionCompte = value;
    }

    get validTypeTransactionLibelle(): boolean {
        return this._validTypeTransactionLibelle;
    }
    set validTypeTransactionLibelle(value: boolean) {
        this._validTypeTransactionLibelle = value;
    }
    get validTypeTransactionCode(): boolean {
        return this._validTypeTransactionCode;
    }
    set validTypeTransactionCode(value: boolean) {
        this._validTypeTransactionCode = value;
    }
    get validCompteNumeroCompte(): boolean {
        return this._validCompteNumeroCompte;
    }
    set validCompteNumeroCompte(value: boolean) {
        this._validCompteNumeroCompte = value;
    }
    get validCompteBanque(): boolean {
        return this._validCompteBanque;
    }
    set validCompteBanque(value: boolean) {
        this._validCompteBanque = value;
    }
    get validCompteProprietaire(): boolean {
        return this._validCompteProprietaire;
    }
    set validCompteProprietaire(value: boolean) {
        this._validCompteProprietaire = value;
    }


}
