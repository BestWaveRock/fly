import com.alibaba.nacos.plugin.auth.impl.utils.PasswordEncoderUtil;
import org.jasypt.encryption.pbe.PBEStringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
	public static void main(String[] args) {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();

		// 配置加密参数
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		config.setPassword("biscuits");                // 加密密钥（需妥善保管）
		config.setAlgorithm("PBEWithMD5AndDES");   // 加密算法（推荐使用更安全的PBEWITHHMACSHA512ANDAES_256）
		config.setKeyObtentionIterations(1000);    // 密钥获取迭代次数
		config.setPoolSize(4);                     // 连接池大小（根据并发需求调整）

		encryptor.setConfig(config);
		encryptor.initialize();                    // 显式初始化（非必须但建议）

		// 加密示例
		String encryptedBiscuits = encryptor.encrypt("biscuits");
		String encryptedPig = encryptor.encrypt("pig");
		String encryptedFly = encryptor.encrypt("fly");
		String Ljx123456 = encryptor.encrypt("Ljx123456");

		System.out.println("Encrypted 'biscuits': ENC(" + encryptedBiscuits + ")");
		System.out.println("Encrypted 'pig': ENC(" + encryptedPig + ")");
		System.out.println("Encrypted 'fly': ENC(" + encryptedFly + ")");
		System.out.println("Encrypted 'Ljx123456': ENC(" + Ljx123456 + ")");


		System.out.println(PasswordEncoderUtil.encode("Ljx123456"));
		System.out.println(new BCryptPasswordEncoder().matches("Ljx123456", "$2a$10$fYWrxliVwglPa.n0KMMP.Oe55olI.tWWxGX6w9DosHF5tL.wSX/Ee"));
		System.out.println(new BCryptPasswordEncoder().matches("nacos", "$2a$10$W6PKgRTzXUp6R/NY853Kn.nRaIcX3whIMTZ/WWkNqo2MTOeSBjKJq"));
	}
}
