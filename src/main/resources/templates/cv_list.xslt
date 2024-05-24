<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:cv24="http://univ.fr/cv24">
    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
                <link rel="stylesheet" type="text/css" href="/css/cvliststyles.css"/>
                <style>
                    .navbar-custom {
                    background-color: #e0e0e0; /* Light gray color */
                    }
                    .container-custom {
                    background-color: #ffffff; /* White color */
                    padding: 20px;
                    box-shadow: 0 4px 8px rgba(0,0,0,0.1);
                    }
                </style>
                <title>Liste des CVs</title>
            </head>
            <body>
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">Navbar</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-item nav-link" href="/">Accueil</a>
                        <a class="nav-item nav-link active" href="/cv24/resume">CV</a>
                        <a class="nav-item nav-link" href="/help">Aide</a>
                    </div>
                </div>
            </nav>

                <div class="container container-custom mt-4">
                    <h1>Liste des CVs</h1>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Genre</th>
                                <th>Prénom</th>
                                <th>Nom</th>
                                <th>Objectif</th>
                                <th>Diplôme</th>
                            </tr>
                        </thead>
                        <tbody>
                            <xsl:for-each select="CvSummaries/CvSummary">
                                <tr>
                                    <td><xsl:value-of select="id"/></td>
                                    <td><xsl:value-of select="genre"/></td>
                                    <td><xsl:value-of select="prenom"/></td>
                                    <td><xsl:value-of select="nom"/></td>
                                    <td><xsl:value-of select="objectif"/></td>
                                    <td><xsl:value-of select="diplome"/><a href="/cv24/html?id={id}" class="button">Voir Détails</a></td>

                                </tr>
                            </xsl:for-each>
                        </tbody>
                    </table>
                </div>

                <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
