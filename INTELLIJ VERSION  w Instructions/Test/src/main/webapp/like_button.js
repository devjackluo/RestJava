'use strict';

const e = React.createElement;

class LikeButton extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            liked: false,
            error: null,
            isLoaded: false,
            items: []
        };
    }

    componentDidMount() {

        // fetch("http://localhost:8080/services/random")
        //     .then(res => res.json())
        //     .then(
        //         (result) => {
        //             this.setState({
        //                 isLoaded: true,
        //                 items: result.randoms
        //             });
        //         },
        //         // Note: it's important to handle errors here
        //         // instead of a catch() block so that we don't swallow
        //         // exceptions from actual bugs in components.
        //         (error) => {
        //             this.setState({
        //                 isLoaded: true,
        //                 error
        //             });
        //         }
        //     )

        fetch('http://localhost:8080/services/random', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                stuff: 'yourValue',
                more: 'yourOtherValue',
            })
        })
        .then(res => res.json())
        .then(
            (result) => {
                this.setState({
                    isLoaded: true,
                    items: result.randoms
                });
            },
            // Note: it's important to handle errors here
            // instead of a catch() block so that we don't swallow
            // exceptions from actual bugs in components.
            (error) => {
                this.setState({
                    isLoaded: true,
                    error
                });
            }
        )
    }

    render() {

        if (this.state.liked) {
            console.log(this.state.items[0].stuff);
            // return [
            //     e(
            //         'div',
            //         null,
            //         this.state.items[0].stuff
            //     ),
            //     e(
            //         'div',
            //         null,
            //         this.state.items[1].stuff
            //     )
            // ];
            return this.state.items.map((random, index) => e('div', null, index + random.stuff))
        }

        return e(
            'button',
            {onClick: () => this.setState({liked: true})},
            'Like'
        );
    }
}

//const domContainer = document.querySelector('#like_button_container');
//ReactDOM.render(e(LikeButton), domContainer);

ReactDOM.render(
    React.createElement(LikeButton, null, null),
    document.getElementById('like_button_container')
);
