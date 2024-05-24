<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="3.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:cv24="http://univ.fr/cv24" xmlns:date="http://exslt.org/dates-and-times">
    <xsl:template match="/">
        <html>
            <head>
                <title>CV24 - XSLT V1.0</title>
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
                <link rel="stylesheet" type="text/css" href="/css/cv.css"/>
            </head>
            <body>
                <!-- Navbar -->
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
                <div class="pad">
                    <h1>CV24 - XSLT V1.0</h1>
                    <xsl:apply-templates select="cv24:cv24"/>
                </div>


                <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="cv24:cv24">
        <xsl:apply-templates select="cv24:identite"/>
        <xsl:apply-templates select="cv24:objectif"/>
        <xsl:apply-templates select="cv24:prof"/>
        <xsl:apply-templates select="cv24:competences"/>
        <xsl:apply-templates select="cv24:divers"/>
    </xsl:template>

    <xsl:template match="cv24:identite">
        <h2><xsl:value-of select="concat(cv24:Genre, ' ', cv24:nom, ' ', cv24:prenom)"/></h2>
        <p>Tel : <xsl:call-template name="format-phone"><xsl:with-param name="number" select="cv24:tel"/></xsl:call-template></p>
        <p>Mel : <xsl:value-of select="cv24:mel"/></p>
    </xsl:template>

    <xsl:template match="cv24:objectif">
        <h2><xsl:value-of select="."/></h2>
        <p>Demande de <xsl:value-of select="cv24:objectif/@statut"/></p>
    </xsl:template>

    <xsl:template match="cv24:prof">
        <h2>Expériences professionnelles</h2>
        <ol>
            <xsl:for-each select="cv24:detail">
                <li class="alt-color">
                    <xsl:value-of select="cv24:titre"/>
                    <xsl:text> (</xsl:text>

                    <xsl:choose>
                        <xsl:when test="cv24:datefin">
                            <xsl:value-of select="concat('du ', cv24:datedeb)"/>
                            <xsl:text> au </xsl:text>
                            <xsl:value-of select="cv24:datefin"/>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:text> depuis le </xsl:text>
                            <xsl:value-of select="cv24:datedeb"/>
                        </xsl:otherwise>
                    </xsl:choose>
                    <xsl:text>)</xsl:text>
                </li>
            </xsl:for-each>
        </ol>
    </xsl:template>

    <xsl:template match="cv24:competences">
        <h2>Diplômes</h2>
        <table>
            <tr>
                <th>Date</th>
                <th>Titre</th>
                <th>Niveau</th>
                <th>Institut</th>
            </tr>
            <xsl:for-each select="cv24:diplome">
                <xsl:sort select="@niveau" order="descending"/>
                <tr>
                    <td><xsl:call-template name="format-date"><xsl:with-param name="date" select="cv24:date"/></xsl:call-template></td>
                    <td><xsl:value-of select="cv24:titre"/></td>
                    <td><xsl:value-of select="@niveau"/></td>
                    <td><xsl:value-of select="cv24:institut"/></td>
                </tr>
            </xsl:for-each>
        </table>
        <h2>
            <xsl:text>Certifications (</xsl:text>
            <xsl:value-of select="count(cv24:certif)"/>
            <xsl:text>)</xsl:text>
        </h2>
        <table>
            <tr>
                <th>Dates</th>
                <th>Titre</th>
            </tr>
            <xsl:for-each select="cv24:certif">
                <tr>
                    <td><xsl:call-template name="format-date"><xsl:with-param name="date" select="cv24:datedeb"/></xsl:call-template> - <xsl:call-template name="format-date"><xsl:with-param name="date" select="cv24:datefin"/></xsl:call-template></td>
                    <td><xsl:value-of select="cv24:titre"/></td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>

    <xsl:template match="cv24:divers">
        <h2>Langues</h2>
        <ul>
            <xsl:for-each select="cv24:lv">
                <li><xsl:value-of select="@lang"/> : <xsl:value-of select="@cert"/> (<xsl:value-of select="concat(@nivs, @nivi)"/>)</li>
            </xsl:for-each>
        </ul>
        <h2>Divers</h2>
        <ul>
            <xsl:for-each select="cv24:autre">
                <li><xsl:value-of select="@titre"/>: <xsl:value-of select="@comment"/></li>
            </xsl:for-each>
        </ul>
    </xsl:template>

    <xsl:template name="format-date">
        <xsl:param name="date"/>
        <xsl:value-of select="$date"/>
    </xsl:template>

    <xsl:template name="format-phone">
        <xsl:param name="number"/>
        <xsl:choose>
            <xsl:when test="starts-with($number, '+33')">
                <xsl:value-of select="concat(substring($number, 1, 3), ' (0)', substring($number, 4, 1), ' ', substring($number, 5, 2), ' ', substring($number, 7, 2), ' ', substring($number, 9, 2), ' ', substring($number, 11, 2))"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="$number"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
</xsl:stylesheet>
