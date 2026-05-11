package jp.co.metateam.library.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ログイン関連クラス
 */
@Controller
public class LoginController {

    @GetMapping("/login")//@GetMappingは、GETリクエストを処理するために使用されます。主に、データの取得やWebページの表示に利用されます。例えば、ユーザーがブラウザでURLにアクセスした際に、該当するHTMLページを返す処理を実行します。
    public String login() {
        return "login";
    }
    
    @GetMapping("/")
    public String redirectToIndex() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:book/index";
        }
        return "redirect:/login";
    }
}


