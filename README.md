# workshop-javafx-jdbc

## Curso: Java COMPLETO 2022 Programação Orientada a Objetos + Projetos | Udemy

### http://educandoweb.com.br<br>
### Prof. Dr. Nelio Alves<br>
### Capítulo: Projeto: Aplicação desktop com JavaF e anco de dados MySQL com JDBC <br>

<p>Versão com comentarios 
<a href="https://github.com/rodrigojfagundes/Java-COMPLETO-2022-POO-Projetos-Comentados-/tree/main/Sessao%2023%20-%20workshopt-javafx-jdbc/328%20-%20Saving%20seller/workshop-javafx-jdbc">aqui</a></p>


<b>Objetivo geral:</b>

 Introduzir o aluno ao desenvolvimento de aplicações JavaFX com JDBC <br>
 Permitir que o aluno conheça os fundamentos e a utilização das ferramentas, de modo que ele possa 
depois prosseguir estudando, de forma confortável, as especificidades que desejar<br>



### Main view<br>
<b>Checklist:</b><br> 
 Create FXML "MainView" (package "gui")<br> 
 Load FXML in Main <br>
 Update Main.java <br>



### Main view design <br>
<b>Checklist: </b><br> 
Design MainView.fxml<br> 
Customize menu items <br>
Update Main.java <br>


### Main view controller <br>
<b>Checklist: </b><br>
Create controller <br>
In view, associate controller, ids, events <br>


### About view 
<b>Checklist: </b> <br>
Include util classes to the project (Alerts.java, Constraints.java) <br>
https://github.com/acenelio/javafx5/blob/master/src/gui/util/Alerts.java<br>
https://github.com/acenelio/javafx5/blob/master/src/gui/util/Constraints.java<br>
Create About.fxml (VBox) <br>
In Main.java, expose mainScene reference <br>
In MainViewController.java, create loadView method <br>


### DepartmentList view design 
<b> Checklist: </b> <br> 
Create DepartmentList.fxml (VBox) <br> 
In MainViewController.java, load DepartmentList <br>


### DepartmentList controller 
<b> Checklist: </b> <br> 
 Create model.entities.Department.java <br>
https://github.com/acenelio/demo-dao-jdbc/blob/master/src/model/entities/Department.java<br>
 Create DepartmentListController.java <br>
 In view, associate controller, ids, events<br> 



### DepartmentService 
<b> Checklist: </b> <br>
 Create model.services.DepartmentService.java with findAll method<br> 
 In DepartmentListController: <br>
 Create DepartmentService dependency with set method <br>
 Create ObservableList<Department> <br>
 Create updateTableViewData method<br>


### Initializing action as parameter 
<b> Checklist: </b> <br> 
 Add a Consumer<T> parameter to loadView method <br> 
 After loading view, call accept from the Consumer <br>
 Add a consumer instance on loadView calls <br>


### Adding database access 
<b>Checklist:</b> <br> 
add model.entities.Seller.java<br> 
Add db.properties do project <br>
Add data access packages to project:<br> 
db <br>
model.dao<br> 
model.dao.impl<br> 
In DepartmentService, add DepartmentDao dependency with Factory call <br>


### DepartmentForm (dialog) design 
<b> Checklist: </b> <br> 
Create gui.util.Utils.java with currentStage method <br>
Create DepartmentForm.fxml (AnchorPane) <br>
GridPane 3x3 (anchors: 20 top, 20 left) <br>
Id text box: not editable <br>
Label error: red<br>
HBox (spacing: 5) <br>
In DepartmentListController, create createDialogForm method <br>
Call createDialogForm on "new" button action <br>


### DepartmentFormController 
<b> Checklist:</b> <br> 
Create DepartmentFormController.java <br>
In view, associate controller, ids, events <br>


### Passing a Department object to DepartmentForm view 
<b>Checklist:</b> <br> 
 In DepartmentFormController <br>
 Create a Department dependency with set method <br>
 Create updateFormData method <br>
 In DepartmentListController <br>
 Update onBtNewAction method <br>
 Update createDialogForm method <br>


### Saving a new Department 
<b> Checklist: </b> <br> 
In Utils, implement tryParseToInt method <br>
In DepartmentService, create saveOrUpdate method<br> 
In DepartmentFormController <br>
Create a DepartmentService dependency with set method<br> 
Implement onBtSaveAction <br>
Implement onBtCancelAction <br>
In DepartmentListController, inject DepartmentService instance <br>





### Observer design pattern to update tableview 
<b> Checklist: </b> <br> 
 Create interface gui.listeners.DataChangeListener<br> 
 In DepartmentFormController (subject) <br>
 Create List<DataChangeListener> dependency with subscribe method<br> 
 Notify subscribers when needed <br>
 In DepartmentListController (observer)<br> 
 Implement DataChangeListener interface <br>
 Subscribe for DepartmentFormController<br>


### Validation exception 
<b> Checklist: </b> <br> 
Create model.exceptions.ValidationException <br> 
In DepartmentFormController <br>
In getFormData method, implement verifications and throw ValidationException <br> 
Implement setErrorMessages method <br>
In onBtSaveAction, catch ValidationException<br>


### Update department 
<b> Checklist: </b> <br> 
In DepartmentListController<br> 
Create new attribute: TableColumn<Department, Department> tableColumnEDIT;<br> 
Create initEditButtons method <br>
In updateTableViewData, call initEditButtons <br>
In DepartmentList.fxml <br>
Include new table column <br>
Associate id <br>



### Remove department 

<b> Checklist: </b><br> 
In Alerts, create showConfirmation method <br> 
In DepartmentService, create remove method <br> 
In DepartmentListController <br> 
Create new attribute: TableColumn<Department, Department> tableColumnREMOVE; <br> 
Create initRemoveButtons method <br> 
Catch DbIntegrityException <br> 
In updateTableViewData, call initRemoveButtons <br> 
In DepartmentList.fxml <br> 
Include new table column <br> 
Associate id<br> 

### Deleting .settings folder 
<b> Checklist: </b> <br>
.gitignore: .settings/<br>
Delete .settings/ folder<br>



### SellerList 
<b> Checklist: </b> <br>
Clone SellerService <br>
Replace: Department -> Seller<br> 
Clone SellerListController <br>
Replace: Department -> Seller <br>
Comment createDialogForm <br>
Clone SellerList.fxml <br>
Replace: Department -> Seller<br> 
Update MainViewController.onMenuItemSellerAction <br> 


### Seller TableView 

<b>Checklist: </b> <br> 
gui.utils.Util.java <br>
formatTableColumnDate method<br> 
formatTableColumnDouble method <br>
SellerListController <br>
TableColumn attributes (Email, BirthDate, BaseSalary)<br> 
Update initializeNodes <br>
SellerListView <br>
TableColumn (Email, BirthDate, BaseSalary)<br> 
Associate fx:id<br>

### SellerForm 
<b> Checklist: </b> <br> 
Clone SellerFormController<br> 
Replace: Department -> Seller <br>
Clone SellerForm view <br>
Replace: Department -> Seller<br> 
SellerListController <br>
Uncomment createDialogForm<br>


### TextField & DatePicker 
<b>Checklist:</b> <br> 
gui.utils.Util.java <br>
formatDatePicker method <br>
TextField & DatePicker attributes (Email, BirthDate, BaseSalary) <br>
Label error attributes (Email, BirthDate, BaseSalary) <br>
Edit SellerFormView <br>
Bugfix: SellerDaoJDBC.instantiateSeller <br> 
obj.setBirthDate(new java.util.Date(rs.getTimestamp("BirthDate").getTime()));<br> 
Update: initializeNodes <br>
Update: updateFormData <br>


### Department ComboBox 
<b> Checklist: </b> <br> 
Update controller: <br> 
DepartmentService dependency <br> 
attribute <br> 
set method <br> 
ComboBox<Department> comboBoxDepartment <br> 
ObservableList<Department> obsList <br> 
loadAssociatedObjects <br> 
initializeComboBoxDepartment <br> 
updateFormData <br> 
Update view: <br> 
ComboBox <br> 
fx:id <br> 



### Saving Seller 
<b> Checklist: </b> <br>
Update: getFormData <br>
Update: setErrorMessages <br>
