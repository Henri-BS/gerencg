import Container from "@material-ui/core/Container";
import Box from "@material-ui/core/Box";
import Grid from "@material-ui/core/Grid";
import Link from "@material-ui/core/Link";
import "./styles.css";

function Footer() {
    return (
        <footer>
        <Box
            px={{ xs: 3, sm: 10 }}
            py={{ xs: 5, sm: 10 }}
            className="footer-color"
        >
            <Container maxWidth="lg">
                <Grid container spacing={5}>
                    <Grid item xs={12} sm={4}>
                        <Box borderBottom={1}>Ajuda</Box>
                        <Box>
                            <Link href="/" color="inherit">
                                Contato
                            </Link>
                        </Box>
                        <Box>
                            <Link href="/" color="inherit">
                                Suporte
                            </Link>
                        </Box>
                        <Box>
                            <Link href="/" color="inherit">
                                Privacidade
                            </Link>
                        </Box>
                    </Grid>
                    <Grid item xs={12} sm={4}>
                        <Box borderBottom={1}>Site</Box>
                        <Box>
                            <Link href="/" color="inherit">
                                Regras do Site
                            </Link>
                        </Box>
                        <Box>
                            <Link href="/" color="inherit">
                                Membros da Equipe
                            </Link>
                        </Box>
                        <Box>
                            <Link href="/" color="inherit">
                                Notícias
                            </Link>
                        </Box>
                    </Grid>
                    <Grid item xs={12} sm={4}>
                        <Box borderBottom={1}>Conta</Box>
                        <Box>
                            <Link href="/" color="inherit">
                                Login
                            </Link>
                        </Box>
                        <Box>
                            <Link href="/" color="inherit">
                                Cadastro
                            </Link>
                        </Box>
                    </Grid>
                </Grid>
            </Container>
        </Box>
        </footer>
    );
}
export default Footer;
