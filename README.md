# this is a simple java aplication to interact with fibonacci sequence

### https://start.spring.io/    used
### Dependencies
- Spring Web
- Thymeleaf (template engine)
- Spring Boot Dev

###  tutorial 
 - https://www.youtube.com/playlist?list=PLGRDMO4rOGcMbku5WcvZ3I8GMH__qd3I2 (basic thymeleaf)
 - https://www.youtube.com/watch?v=arEf4OXsUXI&t=395s (tasks)

# Notes
 - resources/static for assets like css and js
 - thymeleaf iteration th:each (Iterable, Map, arrays)
 - to automatically create table spring.jpa.hibernate.ddl-auto=update
 - ModelAndView (to map html elements and java class - Spring lib)
 - @DateTimeFormat pass double bracket's
 - on view to use {{}}
 - @GetMapping("/mylink/{id}") (@PathVariable("id") use to get params from url


------------------------------------------------------------------------
public class Desafio {

    //f(n)=f(n-1)+f(n-2)
    //f(0) = 0
    //f(1) = 1

    public static void main(String[] args) {

        System.out.println(func1(47));
    }

    public static int func1(int i) {
        if (i == 0){
            return 0;
        } else if (i == 1){
            return 1;
        } else {
            return func1(i-1 )+func1(i-2);
        }
    }

    //fibonacci
    //programa com frontend e backend para devolver a seq de fibonnaci

}