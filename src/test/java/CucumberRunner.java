/**
 * Created by yasup on 27.11.2019.
 */

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by yasup on 20.11.2019.
 *
 * @CucumberOptions
fetures - путь к тестам файлы с расширением feature/
glue - путь к классам с шагами тестов
tags - тэги тестов, которые будут запущены
plugin - регистрирует плагин форматирования
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/"},
        glue = {"ru.kabanov"},
        plugin = {"ru.kabanov.util.AllureReporter",})

public class CucumberRunner {
}
