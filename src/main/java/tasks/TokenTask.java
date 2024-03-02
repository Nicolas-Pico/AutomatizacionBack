package tasks;

import bodies.TokenDto;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import utils.Environment;

import static net.serenitybdd.screenplay.Tasks.*;
import static utils.Environment.*;

public class TokenTask implements Task {

    private final String username;
    private final String password;
    public static String token;

    public TokenTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Environment environment = new Environment();
        environment.selectUrl();

        TokenDto tokenDto = new TokenDto();
        tokenDto.setUsername(username);
        tokenDto.setPassword(password);

        actor.whoCan(CallAnApi.at(httpToken));
        actor.attemptsTo(Post.to("")
                .with(request -> request
                        .header("Content-Type", "application/json")
                        .body(tokenDto)));
        token = String.valueOf(SerenityRest.lastResponse().jsonPath().getString("token"));
        System.out.println("ESTE ES EL TOKEN: " + token);
    }

    public static TokenTask atService(String username, String password) {
        return instrumented(TokenTask.class, username, password);
    }
}