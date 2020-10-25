import 'dart:html';
import 'dart:convert';

class Conta {
  int id;
  int agencia;
  int conta;
  String name;
  int balance;
    
}

void main(List<String> args) async {
  var result = await HttpRequest.getString('https://igti-film.herokuapp.com/api/accounts');
  List<Conta> contas = new List();
  var contasJson = jsonDecode(result);
  
  for (int i=0; i<contasJson.length; i++) {
    var conta = new Conta();
    conta.id = contasJson[i]["id"];
    conta.agencia = contasJson[i]["agencia"];
    conta.name = contasJson[i]["name"];
    conta.balance = contasJson[i]["balance"];
    contas.add(conta);
  }
                                
//   //1: A Soma total dos depósitos de todas as agências é:
//   int soma = 0;
//   contas.forEach((item)=>soma+=item.balance);    
//   print("1) A Soma total dos depósitos de todas as agências é: ${soma}");
  
//   //2: O número total de contas com mais de 100 reais de saldo é:
//   var contasSaldoMaiorQue100 = contas.where((item)=>item.balance> 100);
//   print("2) O número total de contas com mais de 100 reais de saldo é: ${contasSaldoMaiorQue100.length}");
  
//   //3: O número de contas com mais de 100 reais de saldo na agência 33 é:
//   var contasSaldoMaiorQue100NaAgencia33 = contasSaldoMaiorQue100.where((item)=>item.agencia==33);
//   print("3) O número de contas com mais de 100 reais de saldo na agência 33 é: ${contasSaldoMaiorQue100NaAgencia33.length}");
  
//   //4: A Agência com que tem a conta com maior saldo é a:
//   contas.sort((conta1, conta2)=>conta2.balance - conta1.balance);
//   var agenciaMaiorSaldo = contas.map((conta)=>conta.agencia).toList();
//   print("4: A Agência com que tem a conta com maior saldo é a: ${agenciaMaiorSaldo[0]}");
  
//   //5: A Agência com a conta de menor saldo é a
//   print("5: A Agência com a conta de menor saldo é a: ${agenciaMaiorSaldo[agenciaMaiorSaldo.length-1]}");
  
  //para tirar prova
  //contas.sort((conta1, conta2)=>conta2.balance - conta1.balance);  
  //contas.forEach((item)=>print("Agencia:${item.agencia} - balance:${item.balance}"));
  
  //6: Pegue o cliente com o maior saldo em cada agência, o valor total desses saldos é (caso haja mais de um cliente com o maior saldo, escolha apenas um):
  
//   var contasMap = contas.map((item)=>item.agencia);
  
//   var contasUnicas = contasMap.toSet().toList();//.forEach((item)=>print(item));
  
//   var somaMaioresSaldos = 0;
//   for(int i=0; i<contasUnicas.length; i++) {
//     var maiorSaldoNaAgencia = contas.where((item)=> item.agencia == contasUnicas[i]).toList();
//     maiorSaldoNaAgencia.sort((conta1, conta2)=>conta2.balance - conta1.balance);
//     somaMaioresSaldos += maiorSaldoNaAgencia[0].balance;
//     print("Agencia ${contasUnicas[i]} => Maior Saldo: ${maiorSaldoNaAgencia[0].balance}");
//     //maiorSaldoNaAgencia.forEach((item)=>print(item.balance));
//   }
  
//   print("6) Soma dos maiores saldos: ${somaMaioresSaldos}");
  
//   //7) O nome do(a) cliente com o maior saldo na agência 10 é:
//   var maiorSaldoNaAgencia10 = contas.where((item)=> item.agencia == 10).toList();
//   maiorSaldoNaAgencia10.sort((conta1, conta2)=>conta2.balance - conta1.balance);
//   print("7) O nome do(a) cliente com o maior saldo na agência 10 é: ${maiorSaldoNaAgencia10[0].name} com  ${maiorSaldoNaAgencia10[0].balance}");
  
//   //8) O nome do(a) cliente com o menor saldo na agência 47 é:
//   var menorSaldoNaAgencia47 = contas.where((item)=> item.agencia == 47).toList();
//   menorSaldoNaAgencia47.sort((conta1, conta2)=>conta1.balance - conta2.balance);
//   print("8) O nome do(a) cliente com o menor saldo na agência 47 é: ${menorSaldoNaAgencia47[0].name} com  ${menorSaldoNaAgencia47[0].balance}");
  
  //9)Você deve mostrar os nomes dos três clientes com menor saldo, em ordem de saldo (menor para o maior) separados por vírgula da agência 47. Qual seria a sua saída do programa?
//   var menorSaldoNaAgencia47 = contas.where((item)=> item.agencia == 47).toList();
//   menorSaldoNaAgencia47.sort((conta1, conta2)=>conta1.balance - conta2.balance);
//   var nomes = menorSaldoNaAgencia47.take(3).map((item)=>item.name).join(", ");
//   print("9)Você deve mostrar os nomes dos três clientes com menor saldo, em ordem de saldo (menor para o maior) separados por vírgula da agência 47. : ${nomes}");
  
  //10) Quantos clientes estão na agência 47?
//      var clientesAgencia47 = contas.where((item)=> item.agencia == 47);
  
//      clientesAgencia47.forEach((item)=>print(item.name));
//      var clientesAgencia47Map = clientesAgencia47.map((item)=>item.name);
  
//      var clientesUnicosAgencia47Map = clientesAgencia47Map.toSet().toList().forEach((item)=>print(item));
  
//      print("10) Quantos clientes estão na agência 47? ${clientesUnicosAgencia47Map.length}");
  
  
  //11) Quantos clientes que têm "Maria" no nome estão na agencia 47?
//   var clientesAgencia47 = contas.where((item)=> item.agencia == 47);
//   var clientesMariaNaAgencia47 = clientesAgencia47.where((item)=>item.name.contains("Maria")).toList();
//   //clientesMariaNaAgencia47.forEach((item)=>print(item.name));
//   print("11) Quantos clientes que têm 'Maria' no nome estão na agencia 47? ${clientesMariaNaAgencia47.length}");
  
  //12) Considerando que o id deve ser único e é sequencial, qual o próximo id possível para conta?
//   contas.sort((conta1, conta2)=> conta2.id - conta1.id);
//   print("12) Considerando que o id deve ser único e é sequencial, qual o próximo id possível para conta? ${contas[0].id+1}");

  
 
  
  //var contasAgencia33 = contas.where((item)=>item.agencia == 33).toList();
  
  //print(contas.every((conta)=>conta.agencia==33));
//   contasAgencia33.sort((conta1,conta2)=>conta2.balance - conta1.balance);
//   var balancesAgencia33 = contasAgencia33.map((conta)=>conta.balance);
//   balancesAgencia33.forEach((balance)=>print(balance));
  
  //   contasAgencia33.forEach((conta)=>print(conta.name));

  //var nomesAgencia33 = contasAgencia33.map((conta)=>conta.name);
  
  //nomesAgencia33.forEach((name)=>print(name));
  
//   for (int j=0; j<contasAgencia33.length; j++) {
//     print(contas[j].balance);  
//   }
  
//   print(contas[1].balance);
  
  
//   try {
//     print(divide(12, a));  
//   } on IntegerDivisionByZeroException {
//     print("Divisor não pode ser zero");
//   } catch(e) {
//     print("Error - ${e.toString()}");
//   }
  
}

divide(int valor1, int valor2) {
   if (valor2 == 0) {
     throw new IntegerDivisionByZeroException();
   }
  return valor1 / valor2;
}