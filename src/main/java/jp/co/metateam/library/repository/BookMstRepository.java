package jp.co.metateam.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jp.co.metateam.library.model.BookMst;
import java.util.List;
import java.util.Optional;

public interface BookMstRepository extends JpaRepository<BookMst, Long> {
//extends = 機能を引き継ぐ
// BookMstRepositoryはJpaRepositoryの機能を使える

// JpaRepositoryとは、Springが用意しているDB操作便利セット

// <BookMst, Long>
// BookMst = どのEntity(DBテーブル)を扱うか
// Long = 主キー(id)の型

// そのため、save(), findAll(), findById(), delete() などの
// DB操作機能が最初から使える

// だからService側で
// bookMstRepository.save(bookMst);
// と書くだけでDB保存できる

//serviceはコントローラから受け取った入力値をDB保存用にentity型に変換
//repositoryはserviceから渡されたentityをDBに保存する
//以下はどんなSQLをDBへ投げるかを書く場所
//DB（データ保管場所）、SQL（DBへ命令する言葉）
	@Query(value = "SELECT * FROM book_mst LIMIT 1000", nativeQuery = true)//nativeQuery = trueはこれは本物のSQLです→MySQLへ直接このSQLを投げます(P)
	//book_mstテーブルへこのSQLを直接実行してください
	List<BookMst> findLimitedBook();

	@Query(value = "SELECT * FROM book_mst WHERE id = ?1", nativeQuery = true)
	Optional<BookMst> selectById(Long id);
}
//@Query(...)は、このSQLy(...)を実行してくださいというSpringへの指示。
//Pなぜわざわざ書く？
//Springは普段、JPQL（javaのEntity基準で書く）というSpring独自ルールも使えるから。
//native SQL=DBテーブル基準
