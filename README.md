# Enum
- tipo para especificar conjunto de constante relacionadas
- por padrão quando atribuido a um objeto transforma o nome da constante em string 
```Java
public static void main(String[] args) throws Exception {
// order.status = PENDING_PAYMENT
Order order = new Order(
    1080,
    new Date(),
    OrderStatus.PENDING_PAYMENT
);

```
## Conversão string -> enum
```java
// retorna instancia do OrderStatus com valor delivered
OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
```

# Composição
- permite que um objeto contém outro
  - tem um ou tem vários
- Vantagens
  - organização
    - divisão de responsabilidades
  - coesão
  - flexibilidade
  - reuso

# String builder
```java
public String toString() {
  StringBuilder string = new StringBuilder();
  string.append(title + "\n");
  string.append(likes);
  string.append(" Likes - ");

  return string.toString();
}
```