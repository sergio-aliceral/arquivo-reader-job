package br.com.aliceraltecnologia.arquivoreaderjob.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiplosArquivosWriterConfig {

	@Bean
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ItemWriter multiplosArquivosWriter() {
		return items -> items.forEach(System.out::println);
	}
}
