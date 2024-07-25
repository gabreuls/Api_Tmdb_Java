package com.example;

import java.io.PrintWriter;
import java.util.List;

public class HTMLGenerator {
    
    private final PrintWriter writer;
    
    public HTMLGenerator(PrintWriter writer) {

        this.writer = writer;
    }

    public void generate(List<? extends Content> listaContent) {
        writer.println(

        """
            <html>
		        <head>
			    <meta charset=\"utf-8\">
			    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
			    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
						+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">
						
		    </head>
		    <body>
                """);


            writer.println("<div class=\"container\">"); // Início do container
            writer.println("<div class=\"row\">"); // Início da primeira fila

            for(int i = 0; i < listaContent.size(); i++) {
                Content content = listaContent.get(i);
                String div = 
                    """
                        <div class="col-md-4">
                            <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
                                <h4 class="card-header">%s</h4>
                                    <div class="card-body">
                                    <img class="card-img" src="%s" alt="%s">
                                    <p class="card-text mt-2">Nota: %s - Ano: %s</p>
                                </div>
                            </div>
                        </div>
                    """;

                writer.println(String.format(div, content.title(), content.urlImagem(), content.title(), content.rating(), content.year()));

                // Quebra a linha após cada 3 cartões
                if ((i + 1) % 3 == 0) {
                    writer.println("</div>"); // Fecha a linha atual
                    writer.println("<div class=\"row\">"); // Abre uma nova linha
                }
            }

            writer.println("</div>"); // Fecha a última linha
            writer.println("</div>"); // Fecha o container

        writer.println(
            """
                </body>
            </html>
            """
        );
    }
}
