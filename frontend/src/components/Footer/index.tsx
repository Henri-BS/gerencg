import Container from "@material-ui/core/Container";
import Box from "@material-ui/core/Box";
import Grid from "@material-ui/core/Grid";
import Link from "@material-ui/core/Link";
import IGithub from 'assets/img/git.svg'
import ILinkedIn from 'assets/img/linked.svg'
import IGmail from 'assets/img/gmail.svg'

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
                        <Box borderBottom={1}>Contato</Box>
                        <Box>
                            <Link href="https://github.com/Henri-BS" color="inherit">
                            <img className='footer-logo' src={IGithub} alt='logo' />
                                Github
                            </Link>
                        </Box>
                        <Box>
                            <Link href="mailto:rickalmeida720@gmail.com" color="inherit">
                            <img className='footer-logo' src={IGmail} alt='logo' />
                                Gmail
                            </Link>
                        </Box>
                        <Box>
                            <Link href="https://www.linkedin.com/in/h-b-santos-1758351a3/" color="inherit">
                            <img className='footer-logo' src={ILinkedIn} alt='logo' />
                                LinkedIn
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
