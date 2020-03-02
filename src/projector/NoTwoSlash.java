package projector;

import com.sun.codemodel.internal.JCatchBlock;
import sun.jvm.hotspot.utilities.StreamMonitor;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * # Існує популярний веб-сервер задача якого прибирати зайві символи "/".
 * # Наприклад, рядок "/page1///page2////page3/test.html" має стиснутись до "/page1/page2/page3/test.html"
 * # На жаль, оригінальний алгоритм має квадратичну складність,
 * # чим можуть скористатись хакери відправивши одночасно ряд запитів з великою кількістью символів "/".
 * # Вас запросили як спеціаліста з алгоритмів для усунення потенційної небезпеки. Пришвидшіть оригінальний алгоритм, аби він працював за лінію.
 * # python3
 *
 *
 * def noTwoSlash(url: str):
 *     _list = list(url)
 *     i = 1
 *     while i < len(_list):
 *         if (_list[i-1] == '/') and (_list[i] == '/'):
 *             for y in range(i+1, len(_list)):
 *                 _list[y-1] = _list[y]
 *             _list = _list[:-1]
 *         else:
 *             i += 1
 *     return ''.join(_list)
 */

public class NoTwoSlash {

    public void main(String[] args) {
        System.out.println(noTwoSlash("/page1///page2////page3/test.html"));
        System.out.println(noTwoSlash("///////page1///page2////page3/test./as////"));
        System.out.println(noTwoSlash("a/b/c"));
        System.out.println(noTwoSlash("///"));
        System.out.println(noTwoSlash("a"));
        System.out.println(noTwoSlash(""));
    }

    public static String noTwoSlash(String url) {
        char[] chars = new char[url.length()];
        int count = 0;
        for (int i = 0; i < url.length(); i++) {
            if (i == url.length() - 1 || url.charAt(i) != '/' || url.charAt(i + 1) != '/') {
                chars[count++] = url.charAt(i);
            }
        }
        return new String(chars, 0, count);
    }
}








